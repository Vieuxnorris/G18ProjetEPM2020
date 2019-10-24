package be.heh.entity;

import be.heh.entity.PaymentSchedule;

import java.util.Calendar;

public class MonthlyPaymentySchedule implements PaymentSchedule {

    @Override
    public boolean isPayday(Calendar date) {
        return LastDayofMonth(date);
    }

    @Override
    public Calendar getPayPeriodStartDate(Calendar payPeriodEndDate) {
        Calendar firstofMonth = (Calendar) payPeriodEndDate.clone();
        firstofMonth.set(Calendar.DAY_OF_MONTH, 1);
        return firstofMonth;
    }

    private boolean LastDayofMonth(Calendar date)
    {
        return getNextDay(date).get(Calendar.MONTH) != date.get(Calendar.MONTH);
    }

    private Calendar getNextDay(Calendar date)
    {
        Calendar nextDay = (Calendar) date.clone();
        nextDay.add(Calendar.DAY_OF_MONTH, 1);
        return nextDay;
    }
}
