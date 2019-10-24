package be.heh.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class TestEmployee {

    private Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee(100, "toto", "av maistriau");
    }

    @Test
    public void createSalariedEmployee() {

        employee.setClassification(new SalariedClassification(1000));
        employee.setMethod(new DirectDepositMethod("ING","be80-4444-444"));
        employee.setSchedule(new MonthlyPaymentySchedule());

        Assert.assertEquals(1000.0,employee.getSalary(),0.01);

        PaymentSchedule ps = employee.getSchedule();
        assertTrue(ps instanceof MonthlyPaymentySchedule);

        PaymentMethod pm = employee.getMethod();
        Assert.assertEquals("direct deposit into ING : be80-4444-444",pm.toString());
    }

    @Test
    public void createHourlyEmployee() {

        employee.setClassification(new HourlyClassification(20.0));
        employee.setMethod(new MailMethod("toto@gmail.com"));
        employee.setSchedule(new WeeklyPaymentSchedule());

        Calendar date = new GregorianCalendar(2019,10,1);
        Calendar nextDate = new GregorianCalendar(2019,10,2);
        PaymentClassification classification = employee.getClassification();
        ((HourlyClassification)classification).addTimeCard(new TimeCard(date, 8.0));
        ((HourlyClassification)classification).addTimeCard(new TimeCard(nextDate, 10.0));

        Assert.assertEquals(380.0,employee.getSalary(),0.01);

        PaymentSchedule ps = employee.getSchedule();
        assertTrue(ps instanceof WeeklyPaymentSchedule);

        PaymentMethod pm = employee.getMethod();
        Assert.assertEquals("mail : toto@gmail.com",pm.toString());

    }
}
