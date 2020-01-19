package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.Context;
import be.heh.EPGMG5.usecase.AddCommissionEmp;
import be.heh.EPGMG5.usecase.SalesReceiptTransaction;
import be.heh.EPGMG5.usecase.SalesReceiptTransaction;
import be.heh.EPGMG5.usecase.TimeCardTransaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestSaleReceipt {
    @Before
    public void setup()
    {
        TestSetup.setupContext();
    }

    @Test
    public void testTimeCardTransaction() {
        int empID = 2;

        AddCommissionEmp t = new AddCommissionEmp(empID, "Bill", "Home", 1500.0,50.0);
        t.execute();

        Calendar date = new GregorianCalendar(2001, Calendar.NOVEMBER, 9);

        SalesReceiptTransaction srt = new SalesReceiptTransaction(empID, date, 8.0);
        srt.execute();

        Employee e = Context.employeeGateway.getEmployee(empID);
        assertNotNull(e);

        Assert.assertNotNull(t);

        PaymentClassification pc = e.getPayClassification();
        assertTrue(pc instanceof CommissionedClassification);

        CommissionedClassification cc = (CommissionedClassification) e.getPayClassification();
        Assert.assertNotNull(pc);
        SalesReceipt tc = cc.getSalesReceipt(date);
        Assert.assertEquals(8.0, tc.getAmount(), 0.001);
    }
}
