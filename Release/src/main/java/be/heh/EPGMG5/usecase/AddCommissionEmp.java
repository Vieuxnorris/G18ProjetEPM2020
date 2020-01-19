package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.*;
import be.heh.EPGMG5.usecase.AddEmp;

public class AddCommissionEmp extends AddEmp {

    private double Mtly_slry;
    private double ComRate;

    public AddCommissionEmp(int empid, String name, String address, double salary, double commissionRate) {
        super(empid, name, address);
        this.Mtly_slry = salary;
        this.ComRate = commissionRate;
    }

    @Override
    public PaymentSchedule makePaymentSchedule() {
        return new TwoWeeklyPaymentSchedule();
    }

    @Override
    public PaymentClassification makePaymentClassification() {
        return new CommissionedClassification(Mtly_slry, ComRate);
    }

    @Override
    public PaymentMethod makePaymentMethod() {
        return new MailMethod("toto@gmail.be");
    }

/*    @Override
    PaymentClassification getClassification() {
        return new CommissionedClassification(Mtly_slry, ComRate);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new TwoWeeklyPaymentSchedule();
    }*/
}
