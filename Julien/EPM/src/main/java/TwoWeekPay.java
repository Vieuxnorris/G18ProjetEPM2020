public class TwoWeekPay implements PaymentSchedule {
    @Override
    public PaymentSchedule getPaySchedule() {
        return this;
    }
}
