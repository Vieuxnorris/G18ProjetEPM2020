import java.util.Calendar;

public class SaleReceipt {
    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Calendar getDate() {
        return Date;
    }

    public void setDate(Calendar date) {
        Date = date;
    }

    double saleAmount;
    Calendar Date;

    public SaleReceipt(Calendar c, double s){
        this.Date = c;
        this.saleAmount = s;
    }
}
