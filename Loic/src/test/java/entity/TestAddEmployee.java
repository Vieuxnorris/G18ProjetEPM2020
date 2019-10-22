package entity;

import junit.extensions.TestSetup;
import org.junit.Before;
import org.junit.Test;
import usercase.AddHourlyEmployee;
import usercase.AddSalariedEmployee;

import javax.naming.Context;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAddEmployee {
    @Before
    public void setup(){
        SetupTest.setupContext();
    }

    @Test
    public void testAddSalariesEmployee(){
        int empId=1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId,"Bob","Home",1000.00);
        t.execute();

        Employee e = Context.employeeGateway.getEmployee(empId);
        assertEquals("Bob",e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof MonthlyPaymentSchedule);

        PaymentMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis : be332211",pm.toString());
    }

    @Test
    public void testAddHourlyEmployee(){
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "BobHourly","HomeHoulry",20.0);
        t.execute();

        Employee e = Context.employeeGateway.getEmployee(empId);
        assertEquals("BobHourly",e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof WeeklyPaymentSchedule);

        PaymentMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis : be332211",pm.toString());
    }
}
