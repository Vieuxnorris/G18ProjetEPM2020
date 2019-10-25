package be.heh.entity;

import be.heh.usecase.AddHourlyEmployee;
import be.heh.usecase.ChangeAddressTransaction;
import be.heh.usecase.ChangeNameTransaction;
import be.heh.usecase.ChangeSalariedTransaction;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.System.err;

public class TestChangeDetails {
    @Test
    public void testChangeAddressTransaction() throws Exception {
        err.println("TestChangeAddressTransaction");
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 15.25);
        t.execute();
        ChangeAddressTransaction cat = new ChangeAddressTransaction(empId, "Work");
        cat.execute();

        Employee e = PayrollDatabase.instance.getEmployee(empId);
        Assert.assertNotNull(e);
        Assert.assertEquals("Work", e.getAddress());
    }

    @Test
    public void testChangeNameTransaction() throws Exception
    {
        err.println("TestChangeNameTransaction");
        int empId = 3;
        AddHourlyEmployee h = new AddHourlyEmployee(empId, "Bob", "Home", 15.25);
        h.execute();
        ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "Joseph");
        cnt.execute();

        Employee e = PayrollDatabase.instance.getEmployee(empId);
        Assert.assertNotNull(e);
        Assert.assertEquals("Joseph", e.getName());
    }

    @Test
    public void testChangeSalariedTransaction() throws Exception {
        err.println("TestChangeSalariedTransaction");
        int empId = 4;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Lance", "Home", 15.25);
        t.execute();

        ChangeSalariedTransaction cst = new ChangeSalariedTransaction(empId, 1000.00);
        cst.execute();

        Employee e = PayrollDatabase.instance.getEmployee(empId);
        Assert.assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        Assert.assertNotNull(pc);
        SalariedClassification sc = (SalariedClassification) pc;
        Assert.assertNotNull(sc);

        Assert.assertEquals(1000.00, sc.getSalary(), 0.001);
        PaymentSchedule ps = e.getSchedule();
        MonthlyPaymentySchedule ms = (MonthlyPaymentySchedule) ps;
        Assert.assertNotNull(ms);
    }
}
