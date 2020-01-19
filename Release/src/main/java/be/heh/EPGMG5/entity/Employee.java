package be.heh.EPGMG5.entity;

import java.util.Calendar;

public class Employee {

    private int EmpID;
    private String Name;
    private String Address;

    private PaymentClassification PayClassification;
    private PaymentMethod Transaction;
    private PaymentSchedule PayDay;

    public Employee(int id, String name, String address) {
        this.EmpID = id;
        this.Name = name;
        this.Address = address;
    }

    public PaymentSchedule getPaySchedule() {return PayDay;}
    public void setPaySchedule(PaymentSchedule payDay) {this.PayDay = payDay;}

    public PaymentClassification getPayClassification() {return PayClassification;}
    public void setPayClassification(PaymentClassification payClassification) {
        PayClassification = payClassification;}

    public PaymentMethod getPayMethod() {return Transaction;}
    public void setPayMethod(PaymentMethod transaction) {Transaction = transaction;}

    public double calculatePay(PayCheck pc){
        return PayClassification.calculationPay(pc);
    }
/********************************************************************/
    public String getName() {return Name;}
    public void setName(String itsName) {this.Name = itsName;}

    public String getAddress() {return Address;}
    public void setAddress(String itsAddress) {this.Address = itsAddress;}

    public void payday(PayCheck pc) {
        double grossPay = PayClassification.calculationPay(pc);
        pc.setGrossPay(grossPay);
        Transaction.pay(pc);
    }

    public boolean isPayDate(Calendar date) {
        return PayDay.isPayday(date);
    }

    public Calendar getPayPeriodStartDay(Calendar payPeriodEndDate) {
        return PayDay.getPayPeriodStartDate(payPeriodEndDate);
    }
}
