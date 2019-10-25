package be.heh.usecase;

import be.heh.entity.Employee;
import be.heh.entity.PaymentClassification;
import be.heh.entity.PaymentSchedule;

public abstract class ChangeClassificationTranslation extends ChangeEmployeeTransaction {

    public ChangeClassificationTranslation(int Empid)
    {
        super(Empid);
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();

    @Override
    public void change(Employee employee) {
        employee.setClassification(getClassification());
        employee.setSchedule(getSchedule());
    }
}
