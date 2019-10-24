package be.heh.entity;

import be.heh.usecase.AddHourlyEmployee;
import be.heh.usecase.TimeCardTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestTimeCardTransaction {
    @Test
    public void initcard()
    {
        int empID = 15;

        AddHourlyEmployee employeeA = new AddHourlyEmployee(empID, "salut", "HEH", 50.56566);
        employeeA.execute();

        Calendar date = new GregorianCalendar(2019, Calendar.NOVEMBER, 9);
        TimeCardTransaction TimeCardA = new TimeCardTransaction(empID, date, 8.0);
        TimeCardA.execute();

        Employee e = PayrollDatabase.instance.getEmployee(empID);

        Assert.assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        HourlyClassification hc = (HourlyClassification) pc;

        Assert.assertNotNull(e);
        TimeCard tc = hc.getTimeCard(date);
        Assert.assertEquals(8.0, tc.getHours(), 0.001);
    }
}
