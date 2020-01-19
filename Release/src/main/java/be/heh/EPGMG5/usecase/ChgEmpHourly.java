package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.HourlyClassification;
import be.heh.EPGMG5.entity.PaymentClassification;
import be.heh.EPGMG5.entity.PaymentSchedule;
import be.heh.EPGMG5.entity.WeeklyPaymentSchedule;

public class ChgEmpHourly extends ChgEmpPayementClassification {

    private double HourlyRate;

    public ChgEmpHourly(int empId, double rate) {
        super(empId);
        HourlyRate = rate;
    }

    @Override
    public PaymentClassification makePayementClassification() {
        return new HourlyClassification(HourlyRate);
    }

    @Override
    public PaymentSchedule makePayemenentSchedule() {
        return new WeeklyPaymentSchedule();
    }

    /*    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(itsHourlyRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklyPaymentSchedule();
    }*/
}
