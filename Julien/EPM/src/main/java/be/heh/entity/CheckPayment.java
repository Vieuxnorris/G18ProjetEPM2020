package be.heh.entity;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CheckPayment {
    private double grossPay;
    private double deduction;
    private double netPay;
    private Calendar PayPeriodStartDate;
    private Calendar PayPeriodEndDate;
    private Map<String, String> fields;

    public CheckPayment(Calendar payPeriodStartDate, Calendar payPeriodEndDate)
    {
        this.PayPeriodStartDate = payPeriodStartDate;
        this.PayPeriodEndDate = payPeriodEndDate;
        fields = new HashMap<>();
    }

    public double getGrossPay()
    {
        return grossPay;
    }

    public void setGrossPay(double grossPay)
    {
        this.grossPay = grossPay;
    }

    public double getDeduction()
    {
        return deduction;
    }

    public void setDeduction(double deduction)
    {
        this.deduction = deduction;
    }

    public double getNetPay()
    {
        return netPay;
    }

    public void setNetPay(double netPay)
    {
        this.netPay = netPay;
    }

    public Calendar getPayPeriodEndDate()
    {
        return PayPeriodEndDate;
    }

    public Calendar getPayPeriodStartDate()
    {
        return PayPeriodStartDate;
    }

    public void setFields(String name, String value)
    {
        fields.put(name, value);
    }

    public String getField(String name)
    {
        return fields.get(name);
    }
}
