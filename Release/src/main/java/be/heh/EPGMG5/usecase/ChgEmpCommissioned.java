package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.CommissionedClassification;
import be.heh.EPGMG5.entity.PaymentClassification;
import be.heh.EPGMG5.entity.PaymentSchedule;
import be.heh.EPGMG5.entity.TwoWeeklyPaymentSchedule;

public class ChgEmpCommissioned extends ChgEmpPayementClassification {

    private double Salary;
    private double CommissionRate;

    public ChgEmpCommissioned(int empId, double salary, double rate) {
        super(empId);
        this.Salary = salary;
        this.CommissionRate = rate;
    }

    @Override
    public PaymentClassification makePayementClassification() {
        return new CommissionedClassification(Salary, CommissionRate);
    }

    @Override
    public PaymentSchedule makePayemenentSchedule() {
        return new TwoWeeklyPaymentSchedule();
    }

    /*    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(Salary, CommissionRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new TwoWeeklyPaymentSchedule();
    }*/
}
