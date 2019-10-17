public class CashMethod implements PaymentMethod {
    @Override
    public PaymentMethod getPayMethod() {
        return this;
    }

    @Override
    public String toString() {
        return "Cash";
    }
}
