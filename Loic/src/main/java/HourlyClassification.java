import java.util.Calendar;
import java.util.HashMap;

public class HourlyClassification implements PaymentClassification {
    double hourSalary;
    double salary;
    TimeCard listTimeCard;


    public HourlyClassification(double h){
        this.hourSalary = h;
    }

    @Override
    public void setPayClassification(double s) {

    }

    @Override
    public double CalculatePay(PaymentClassification p){

        return salary;
    }

    @Override
    public PaymentClassification getPayClassification(){
        return this;
    }

    public void addTimeCard(TimeCard timeCard) {
        this.listTimeCard = timeCard;
        preCalcul();
    }

    public double preCalcul(){
        salary += ((listTimeCard.getHours()) * hourSalary);
        return salary;
    }
}