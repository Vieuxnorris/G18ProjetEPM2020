package be.heh.entity;

import java.util.Calendar;

public abstract class PaymentClassification {
    public abstract double calculationSalary(CheckPayment pc);

    public abstract double getSalary();

    public static boolean PayPeriod(Calendar date, CheckPayment checkPayment)
    {
        Calendar payPeriodStart = checkPayment.getPayPeriodStartDate();
        Calendar payPeriodEnd = checkPayment.getPayPeriodEndDate();
        return date.equals(payPeriodEnd) || date.equals(payPeriodStart) ||
                (date.after(payPeriodStart) && date.before(payPeriodEnd));
    }
}
