package be.heh.usecase;

import be.heh.entity.*;

public class ChangeHourlyTransaction extends ChangeClassificationTranslation {

    private double Salary;

    public ChangeHourlyTransaction(int empId, double salary)
    {
        super(empId);
        this.Salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(Salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklyPaymentSchedule();
    }
}
