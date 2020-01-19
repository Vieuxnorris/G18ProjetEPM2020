package be.heh.EPGMG5.entity;

//import static org.junit.Assert.*;

//import be.heh.entity.*;
import be.heh.EPGMG5.Context;//ajouter
import be.heh.EPGMG5.usecase.AddHourlyEmp;
import be.heh.EPGMG5.usecase.AddSalariedEmp;
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
    AddSalariedEmp t = new AddSalariedEmp(empId, "Bob","Home",1000.00);
    t.execute();

    Employee e = Context.employeeGateway.getEmployee(empId);
    Assert.assertEquals("Bob",e.getName());

    PaymentSchedule ps = e.getPaySchedule();
    assertTrue(ps instanceof MonthlyPaymentSchedule);

    PaymentMethod pm = e.getPayMethod();
    Assert.assertEquals(e.getPayMethod(),pm);
}

    @Test
    public void testAddHourlyEmployee () {
        int empId = 2;
        AddHourlyEmp t = new AddHourlyEmp(empId, "BobHourly","Home_Hourly",20.0);
        t.execute();

        Employee e = Context.employeeGateway.getEmployee(empId);
        Assert.assertEquals("BobHourly",e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof WeeklyPaymentSchedule);

        PaymentMethod pm = e.getPayMethod();
        Assert.assertEquals(e.getPayMethod().toString(),pm.toString());
    }
}
