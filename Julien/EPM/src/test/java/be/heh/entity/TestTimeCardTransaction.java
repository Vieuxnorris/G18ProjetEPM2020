package be.heh.entity;

import be.heh.usecase.AddHourlyEmployee;
import be.heh.usecase.TimeCardTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.System.err;

public class TestTimeCardTransaction {
    @Test
    public void initcard()
    {
        err.println("TestTimeCardTransaction");

        int empId = 2;

        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Calendar date = new GregorianCalendar(2001, Calendar.NOVEMBER, 9);

        TimeCardTransaction tct = new TimeCardTransaction(empId, date, 8.0);
        tct.execute();

        Employee e = PayrollDatabase.instance.getEmployee(empId);

        Assert.assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        HourlyClassification hc = (HourlyClassification) pc;

        Assert.assertNotNull(hc);
        TimeCard tc = hc.getTimeCard(date);
        Assert.assertEquals(8.0, tc.getHours(), 0.001);
    }
}
