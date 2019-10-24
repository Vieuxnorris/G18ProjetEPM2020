package be.heh.usecase;

import be.heh.entity.*;

public class AddCommissionEmployee extends AddEmployeeTransaction {

    private double salary;
    private double commissionRate;

    public AddCommissionEmployee(int empid, String name, String address, double salary, double commissionRate) {
        super(empid, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    PaymentClassification getClassification() {
        return new CommissionedClassification();
    }

    @Override
    PaymentSchedule getSchedule() {
        return new TwoWeeksPaymentSchedule();
    }

}
