package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.entity.PayCheck;

public class SalariedClassification implements PaymentClassification {

    private double Salary;

    public SalariedClassification(double salary) {
        this.Salary = salary;
    }

    public double getSalary() {
        return Salary;
    }

    @Override
    public double calculationPay(PayCheck pc) {
        return Salary;
    }
}
