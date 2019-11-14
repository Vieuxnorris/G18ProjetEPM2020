package be.heh.entity;

import be.heh.usecase.AddEmployeeTransaction;
import be.heh.usecase.AddSalariedEmployee;
import be.heh.usecase.PaydayTransaction;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.System.err;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestPayday {
    @Test
    public void testPaySingleSalariedEmployee() {
        err.println("TestPaySingleSalariedEmployee");

        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Calendar payDay = new GregorianCalendar(2019, Calendar.NOVEMBER, 30);
        PaydayTransaction pt = new PaydayTransaction(payDay);
        pt.execute();
        CheckPayment pc = pt.getPayCheck(empId);
        Assert.assertNotNull(pc);
        Assert.assertEquals(pc.getPayPeriodEndDate(), payDay);
        Assert.assertEquals(1000.00, pc.getGrossPay(), 0.001);
        Assert.assertTrue("Direct".equals(pc.getField("Disposition")));
        Assert.assertEquals(0.0, pc.getDeduction(), 0.001);
        Assert.assertEquals(1000.00, pc.getNetPay(), 0.001);
    }

    @Test
    public void testpaySingleSalariedEmployeeOnWrongDate() throws Exception
    {
        err.println("TestPayMultipleSalariedEmployees");

        AddSalariedEmployee t1 = new AddSalariedEmployee(1, "Bob", "Home", 1000.00);
        AddSalariedEmployee t2 = new AddSalariedEmployee(2, "Bill", "home", 2000.00);
        AddSalariedEmployee t3 = new AddSalariedEmployee(3, "Joan", "Home", 9000.00);
        t1.execute();
        t2.execute();
        t3.execute();

        Calendar payDate = new GregorianCalendar(2001, Calendar.NOVEMBER, 30);
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();

        Assert.assertEquals(3, pt.getPayCheckCount());
        validatePayCheck(pt, 1, payDate, 1000.00);
        validatePayCheck(pt, 2, payDate, 2000.00);
        validatePayCheck(pt,3, payDate, 9000.00);
    }

    private void validatePayCheck(PaydayTransaction pt, int empId, Calendar payDate, double pay)
    {
        CheckPayment pc = pt.getPayCheck(empId);
        Assert.assertNotNull(pc);

        Assert.assertEquals(payDate, pc.getPayPeriodEndDate());
        Assert.assertEquals("Direct", pc.getField("Disposition"));
        Assert.assertEquals(pay, pc.getGrossPay(), 0.001);
        Assert.assertEquals(0.0, pc.getDeduction(), 0.001);
        Assert.assertEquals(pay, pc.getNetPay(), 0.001);
    }
}
