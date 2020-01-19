package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.Context;
import be.heh.EPGMG5.usecase.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import be.heh.EPGMG5.gateways.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TestChangeEmployee {

    @Before
    public void setup()
    {
        TestSetup.setupContext();
    }

    @Test
    public void ChangeName()
    {
        int empID = 2;
        AddHourlyEmp t = new AddHourlyEmp(empID, "BobHourly", "Home_Hourly", 15.25);
        t.execute();
        ChgEmpName tct = new ChgEmpName(empID, "Bibi");
        tct.execute();

        Employee e = Context.employeeGateway.getEmployee(empID);
        Assert.assertNotNull(e);
        Assert.assertEquals("Bibi", e.getName());
    }

    @Test
    public void ChangeAddress()
    {
        int empID = 2;
        AddHourlyEmp t = new AddHourlyEmp(empID, "BobHourly", "Home_Hourly", 15.25);
        t.execute();
        ChgEmpAddress tct = new ChgEmpAddress(empID, "Work_Hourly");
        tct.execute();

        Employee e = Context.employeeGateway.getEmployee(empID);
        Assert.assertNotNull(e);
        Assert.assertEquals("Work_Hourly", e.getAddress());
    }

    @Test
    public void ChangeToHourly()
    {
        int EmpID = 3;
        AddCommissionEmp t = new AddCommissionEmp(EmpID, "Didier", "Home", 1700, 3.0);
        t.execute();

        ChgEmpHourly tct = new ChgEmpHourly(EmpID, 25.50);
        tct.execute();

        Employee e = Context.employeeGateway.getEmployee(EmpID);
        Assert.assertNotNull(e);

        PaymentClassification p = e.getPayClassification();
        Assert.assertNotNull(p);

        HourlyClassification h = (HourlyClassification) p;
        Assert.assertNotNull(h);

        Assert.assertEquals(25.50, h.getHoursSalary(), 0.001);
        PaymentSchedule ps = e.getPaySchedule();

        WeeklyPaymentSchedule w = (WeeklyPaymentSchedule) ps;
        Assert.assertNotNull(w);
    }

    @Test
    public void ChangeToSalaried()
    {
        int EmpID = 3;
        AddCommissionEmp t = new AddCommissionEmp(EmpID, "Didier", "Home", 1700, 3.0);
        t.execute();

        ChgEmpSalaried tct = new ChgEmpSalaried(EmpID, 2000.00);
        tct.execute();

        Employee e = Context.employeeGateway.getEmployee(EmpID);
        Assert.assertNotNull(e);

        PaymentClassification p = e.getPayClassification();
        Assert.assertNotNull(p);

        SalariedClassification h = (SalariedClassification) p;
        Assert.assertNotNull(h);

        Assert.assertEquals(2000, h.getSalary(), 0.001);
        PaymentSchedule ps = e.getPaySchedule();

        MonthlyPaymentSchedule w = (MonthlyPaymentSchedule) ps;
        Assert.assertNotNull(w);

    }

    @Test
    public void ChangeToCommission()
    {
        int EmpID = 3;
        AddSalariedEmp t = new AddSalariedEmp(EmpID, "Didier", "Home", 1700);
        t.execute();

        ChgEmpCommissioned tct = new ChgEmpCommissioned(EmpID, 1700.00, 25.50);
        tct.execute();

        Employee e = Context.employeeGateway.getEmployee(EmpID);
        Assert.assertNotNull(e);

        PaymentClassification p = e.getPayClassification();
        Assert.assertNotNull(p);

        CommissionedClassification h = (CommissionedClassification) p;
        Assert.assertNotNull(h);

        Assert.assertEquals(25.50, h.getCommission(), 0.001);
        PaymentSchedule ps = e.getPaySchedule();

        TwoWeeklyPaymentSchedule w = (TwoWeeklyPaymentSchedule) ps;
        Assert.assertNotNull(w);

    }

    @Test
    public void ChangeToMail()
    {
        int empId = 1;
        AddSalariedEmp t = new AddSalariedEmp(empId, "JANE", "Home", 900);
        t.execute();
        ChgEmpMail cmt = new ChgEmpMail(empId, "Mail");
        cmt.execute();
        Employee e = Context.employeeGateway.getEmployee(empId);
        Assert.assertNotNull(e);
        PaymentMethod pm = e.getPayMethod();
        MailMethod mm = (MailMethod) pm;
        Assert.assertNotNull(mm);
        Assert.assertEquals("Mail", mm.getMail());
    }

    @Test
    public void ChangeToDirect()
    {
        int empId = 1;
        AddSalariedEmp t = new AddSalariedEmp(empId, "JANE", "Home", 900);
        t.execute();

        ChgEmpDirect cmt = new ChgEmpDirect(empId, "BNP", "BE 2405");
        cmt.execute();

        Employee e = Context.employeeGateway.getEmployee(empId);
        Assert.assertNotNull(e);

        PaymentMethod pm = e.getPayMethod();
        DirectDepositMethod mm = (DirectDepositMethod) pm;
        Assert.assertNotNull(mm);

        Assert.assertEquals("BNP", mm.getBank());
        Assert.assertEquals("BE 2405", mm.getAccount());
    }
}
