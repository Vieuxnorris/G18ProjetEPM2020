package be.heh.entity;

import java.util.Calendar;

public interface PaymentSchedule {
    boolean isPayday(Calendar date);
    Calendar getPayPeriodStartDate(Calendar payPeriodEndDate);
}
