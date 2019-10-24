public class MonthlyPaymentSchedule implements PaymentSchedule {
    public MonthlyPaymentSchedule(){
    }

    @Override
    public PaymentSchedule getPaySchedule() {
        return this;
    }
}
