package be.heh.usecase;

import be.heh.entity.*;

public class AddHourlyEmployee extends AddEmployee {
    private int empId;
    private String name;
    private String address;
    private double hrly_rate;

    public AddHourlyEmployee(int empId, String name, String address, double hrly_rate){
        super(empId,name,address);
        this.hrly_rate = hrly_rate;
    }


    @Override
    protected PaymentSchedule makePaymentSchedule() {
        return new WeeklyPaymentSchedule();
    }

    @Override
    protected PaymentClassification makePaymentClassification() {
        return new SalariedClassification(hrly_rate);
    }

   /* @Override
    protected PaymentMethod makePaymentMethod() {
        return null;
    }*/
}
