package be.heh.entity;

import be.heh.entity.PaymentSchedule;

import java.util.Calendar;

public class WeeklyPaymentSchedule implements PaymentSchedule {

    @Override
    public boolean isPayday(Calendar date) {
        return date.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
    }

    @Override
    public Calendar getPayPeriodStartDate(Calendar payPeriodEndDate) {
        Calendar monday = (Calendar) payPeriodEndDate.clone();
        monday.roll(Calendar.DAY_OF_MONTH, -6);
        return monday;
    }
}
