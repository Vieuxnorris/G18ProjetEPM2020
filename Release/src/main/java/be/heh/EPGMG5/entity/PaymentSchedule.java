package be.heh.EPGMG5.entity;

import java.util.Calendar;

public interface PaymentSchedule {

    boolean isPayday(Calendar date);
    Calendar getPayPeriodStartDate(Calendar payPeriodEndDate);
}
