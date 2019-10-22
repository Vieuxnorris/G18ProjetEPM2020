import java.util.Calendar;
import java.util.HashMap;

public class CommissionedClassification implements PaymentClassification {
    double salary;
    double commission;
    double totalCommission;

    SaleReceipt listSaleReceipt;

    public CommissionedClassification(double s){
        this.salary = s;
    }

    @Override
    public void setPayClassification(double s) {

    }

    @Override
    public PaymentClassification getPayClassification() {
        return this;
    }

    @Override
    public double CalculatePay(PaymentClassification p) {
        return salary += totalCommission;
    }

    public void addSaleReceipt(SaleReceipt saleReceipt){
        this.listSaleReceipt = saleReceipt;
        preCalcul(saleReceipt);
    }

    public double preCalcul(SaleReceipt s){

        commission = listSaleReceipt.getSaleAmount();
        return totalCommission += commission;
    }
}