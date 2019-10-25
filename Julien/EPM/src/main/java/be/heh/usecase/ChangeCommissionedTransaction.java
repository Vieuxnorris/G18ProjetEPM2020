package be.heh.usecase;

import be.heh.entity.CommissionedClassification;
import be.heh.entity.PaymentClassification;
import be.heh.entity.PaymentSchedule;
import be.heh.entity.TwoWeeksPaymentSchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTranslation {

    private double Salary;
    private double Rate;

    public ChangeCommissionedTransaction(int empID, double salary, double rate)
    {
        super(empID);
        this.Salary = salary;
        this.Rate = rate;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new TwoWeeksPaymentSchedule();
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification();
    }
}
