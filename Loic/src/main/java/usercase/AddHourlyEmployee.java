package usercase;

public class AddHourlyEmployee extends AddEmployee{
    double hourlyRate;
    public AddHourlyEmployee(int id, String name, String adresse, double hourlyRate){
        super(id,name,adresse);
        this.hourlyRate=hourlyRate;
    }

    @Override
    public PaymentClassification makePaymentClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    public PaymentSchedule makePaymentSchedule() {
        return new WeeklyPaymentSchedule();
    }
}
