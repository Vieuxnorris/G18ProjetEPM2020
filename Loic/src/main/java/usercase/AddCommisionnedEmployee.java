package usercase;

public class AddCommisionnedEmployee extends AddEmployee{
    double salary;
    double commission;
    public AddCommisionnedEmployee(int empID, String name, String adresse, double salary, double commission){
        super(empID,name,adresse);
        this.salary=salary;
        this.commission=commission;
    }
    @Override
    public PaymentClassification makePaymentClassification() {
        return new CommisionnedClassification(salary, commission);
    }

    @Override
    public PaymentSchedule makePaymentSchedule() {
        return new MonthlyPaymentSchedule();
    }
}
