package be.heh.usecase;

import be.heh.entity.MonthlyPaymentySchedule;
import be.heh.entity.PaymentClassification;
import be.heh.entity.PaymentSchedule;
import be.heh.entity.SalariedClassification;

public class ChangeSalariedTransaction extends ChangeClassificationTranslation {

    private double Salary;

    public ChangeSalariedTransaction(int empID, double salary)
    {
        super(empID);
        this.Salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(Salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlyPaymentySchedule();
    }
}
