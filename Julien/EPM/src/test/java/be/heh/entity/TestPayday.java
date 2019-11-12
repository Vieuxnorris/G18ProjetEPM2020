package be.heh.entity;

import be.heh.usecase.AddEmployeeTransaction;
import be.heh.usecase.AddSalariedEmployee;
import be.heh.usecase.PaydayTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.System.err;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestPayday {
    @Test
    public void testPaySingleSalariedEmployee()
    {
        err.println("TestPaySingleSalariedEmployee");

        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Calendar payDay = new GregorianCalendar(2001, Calendar.NOVEMBER, 30);
        PaydayTransaction pt = new PaydayTransaction(payDay);
        pt.execute();
        CheckPayment pc = pt.getPayCheck(empId);
        Assert.assertNotNull(pc);
        Assert.assertEquals(pc.getPayPeriodEndDate(), payDay);
        Assert.assertEquals(1000.00, pc.getGrossPay(), 0.001);
        //Assert.assertTrue("Hold".equals(pc.getField("Disposition")));
        Assert.assertEquals(0.0, pc.getDeduction(), 0.001);
        Assert.assertEquals(1000.00, pc.getNetPay(), 0.001);
    }


}
