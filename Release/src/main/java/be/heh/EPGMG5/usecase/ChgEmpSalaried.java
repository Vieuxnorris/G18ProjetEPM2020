package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.MonthlyPaymentSchedule;
import be.heh.EPGMG5.entity.PaymentClassification;
import be.heh.EPGMG5.entity.PaymentSchedule;
import be.heh.EPGMG5.entity.SalariedClassification;

public class ChgEmpSalaried extends ChgEmpPayementClassification {

    private double Salary;

    public ChgEmpSalaried(int empId, double salary) {
        super(empId);
        this.Salary = salary;
    }

    @Override
    public PaymentClassification makePayementClassification() {
        return new SalariedClassification(Salary);
    }

    @Override
    public PaymentSchedule makePayemenentSchedule() {
        return new MonthlyPaymentSchedule();
    }

    /*    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlyPaymentSchedule();
    }*/
}
