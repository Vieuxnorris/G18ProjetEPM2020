package be.heh.EPGMG5.entity;

import java.util.Calendar;

public class SalesReceipt {

    private Calendar Date;
    private double SaleAmount;

    public SalesReceipt(Calendar date, double amount) {
        this.Date = date;
        this.SaleAmount = amount;
    }

    public Calendar getDate() {
        return Date;
    }

    public double getAmount() {
        return SaleAmount;
    }
}
