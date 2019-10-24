package be.heh.usecase;

import be.heh.entity.*;

public class AddCommissionEmployee extends AddEmployee {
    private int empId;
    private String name;
    private String address;
    private double mlty_slry;
    private double com_rate;

    public AddCommissionEmployee(int empId, String name, String address, double mlty_slry, double com_rate){
        super(empId,name,address);
        this.mlty_slry = mlty_slry;
        this.com_rate = com_rate;
    }

    @Override
    protected PaymentSchedule makePaymentSchedule() {
        return null;
    }

    @Override
    protected PaymentClassification makePaymentClassification() {
        return null;
    }

    /*@Override
    protected PaymentMethod makePaymentMethod() {
        return null;
    }*/
}
