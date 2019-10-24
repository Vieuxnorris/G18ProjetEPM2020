public class Employee {
    private int EmplID;
    private String name;
    private String address;
    private double salary;
    public PaymentClassification paymentClassification;
    public PaymentMethod paymentMethod;
    public PaymentSchedule paymentSchedule;

    public Employee(int id, String name, String address) {
        this.name = name;
        this.EmplID = id;
        this.address = address;
    }

    public double calculatePay(){
        return paymentClassification.CalculatePay(paymentClassification);
    }

    public void setPayClassification(PaymentClassification p){
        paymentClassification = p;
    }

    public PaymentClassification getPayClassification(){
        return paymentClassification.getPayClassification();
    }

    public void setPayMethod(PaymentMethod p){
        paymentMethod = p;
    }

    public PaymentMethod getPayMethod(){

        return paymentMethod.getPayMethod();
    }

    public void setPaySchedule(PaymentSchedule p){
        paymentSchedule = p;
    }
    public PaymentSchedule getPaySchedule(){
        return paymentSchedule.getPaySchedule();
    }
}
