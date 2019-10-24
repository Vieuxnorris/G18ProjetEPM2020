
public interface PaymentClassification {
    void setPayClassification(double s);
    PaymentClassification getPayClassification();
    double CalculatePay(PaymentClassification p);
}