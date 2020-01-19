package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.*;

public class AddHourlyEmp extends AddEmp {

    private double HrlyRate;

    public AddHourlyEmp(int empid, String name, String address, double hrlyRate) {
        super(empid, name, address);
        this.HrlyRate = hrlyRate;
    }

    @Override
    public PaymentSchedule makePaymentSchedule() {
        return new WeeklyPaymentSchedule();
    }

    @Override
    public PaymentClassification makePaymentClassification() {
        return new HourlyClassification(HrlyRate);
    }

    @Override
    public PaymentMethod makePaymentMethod() {
        return new MailMethod("toto@gmail.be");
    }

/*    @Override
    PaymentClassification getClassification() {
        return new HourlyClassification(HrlyRate);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new WeeklyPaymentSchedule();
    }*/
}
