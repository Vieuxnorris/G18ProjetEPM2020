package be.heh.entity;

//import static org.junit.Assert.*;

//import be.heh.entity.*;
import be.heh.Context;//ajouter
import be.heh.usecase.AddHourlyEmployee;
import be.heh.usecase.AddSalariedEmployee;
import org.junit.Assert;//ajouter
import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestAddEmployee {

    @Before
    public void setup(){
        TestSetup.setupContext();
    }

    @Test
    public void testAddSalariedEmployee () {
    int empId = 1;
    AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob","Home",1000.00);
    t.execute();

    Employee e = PayrollDatabase.instance.getEmployee(empId);
    Assert.assertEquals("Bob",e.getName());

    PaymentSchedule ps = e.getSchedule();
    assertTrue(ps instanceof MonthlyPaymentySchedule);

    PaymentMethod pm = e.getMethod();
    Assert.assertEquals("direct deposit into Fortis : be332211",pm.toString());
}

    @Test
    public void testAddHourlyEmployee () {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "BobHourly","Home_Hourly",20.0);
        t.execute();

        Employee e = PayrollDatabase.instance.getEmployee(empId);
        Assert.assertEquals("BobHourly",e.getName());

        PaymentSchedule ps = e.getSchedule();
        assertTrue(ps instanceof WeeklyPaymentSchedule);

        PaymentMethod pm = e.getMethod();
        Assert.assertEquals("direct deposit into Fortis : be332211",pm.toString());
    }


}
