public class SalariedClassification implements PaymentClassification {

    private double salary;

    public SalariedClassification(double i) {
        this.salary = i;
    }

    @Override
    public double CalculatePay(PaymentClassification p){
        return this.salary;
    }

    @Override
    public void setPayClassification(double s) {
        this.salary = s;
    }

    @Override
    public PaymentClassification getPayClassification() {
        return this;
    }
}