package be.heh.EPGMG5.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TwoWeeklyPaymentSchedule implements PaymentSchedule {

    @Override
    public boolean isPayday(Calendar date) {
        Calendar firstPayableFriday = new GregorianCalendar(2001, Calendar.NOVEMBER, 9);
        long diffInDays = (date.getTime().getTime() - firstPayableFriday.getTime().getTime()) / (1000 * 60 * 60 * 24);
        return diffInDays % 14 == 0;
    }

    @Override
    public Calendar getPayPeriodStartDate(Calendar payDate) {
        Calendar result = (Calendar) payDate.clone();
        result.add(Calendar.DAY_OF_MONTH, -13);
        return result;
    }
}
