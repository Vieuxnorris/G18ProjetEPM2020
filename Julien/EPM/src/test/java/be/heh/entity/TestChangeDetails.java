package be.heh.entity;

import be.heh.usecase.AddHourlyEmployee;
import be.heh.usecase.ChangeAddressTransaction;
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
}
