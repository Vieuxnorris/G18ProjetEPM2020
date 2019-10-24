package be.heh.entity;

import be.heh.entity.PaymentClassification;
import be.heh.entity.PaymentMethod;
import be.heh.entity.PaymentSchedule;

import java.lang.reflect.Method;
import java.util.Calendar;

public class Employee {

    private int EmpID;
    private String Name;
    private String Address;

    private PaymentMethod transaction; // strategy
    private PaymentSchedule payDay; // strategy
    private PaymentClassification paymentClassification; // strategy

    public Employee(int id, String name, String address) {
        this.EmpID = id;
        this.Name = name;
        this.Address = address;
    }

    public double getSalary()
    {
        return paymentClassification.getSalary();
    }

    public PaymentSchedule getSchedule()
    {
        return payDay;
    }
    public void setSchedule(PaymentSchedule schedule)
    {
        this.payDay = schedule;
    }

    public PaymentClassification getClassification() {
        return paymentClassification;
    }
    public void setClassification (PaymentClassification classification) {
        paymentClassification = classification;
    }

    public PaymentMethod getMethod()
    {
        return transaction;
    }
    public void setMethod (PaymentMethod method)
    {
        this.transaction = method;
    }

    public String getName()
    {
        return Name;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getAddress()
    {
        return Address;
    }
    public void setAddress(String Address)
    {
        this.Address = Address;
    }

    public void payment(CheckPayment pc)
    {
        double grossPay = paymentClassification.calculationSalary(pc);
        double PayementNet = grossPay;
        pc.setGrossPay(grossPay);
        pc.setNetPay(PayementNet);
        transaction.pay(pc);
    }

    public boolean PayDate(Calendar date)
    {
        return payDay.isPayday(date);
    }

    public Calendar getPayPeriodStartDay(Calendar payPeriodEndDate)
    {
        return payDay.getPayPeriodStartDate(payPeriodEndDate);
    }

}
