package be.heh.entity;

import java.util.Calendar;

public class SaleReceipt extends CommissionedClassification {
    private Calendar date;
    private double saleAmount;

    public SaleReceipt(Calendar date, double saleAmount) {
        this. date = date;
        this.saleAmount = saleAmount;
    }
}
