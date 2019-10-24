package be.heh.usecase;

import be.heh.entity.*;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    private double mlty_slry;

    public AddSalariedEmployee(int empId, String name, String address, double mlty_slry){
        super(empId,name,address);
        this.mlty_slry = mlty_slry;
    }


    @Override
    protected PaymentSchedule getSchedule()
    {
        return new MonthlyPaymentySchedule();
    }

    @Override
    protected PaymentClassification getClassification()
    {
        return new SalariedClassification(mlty_slry);
    }
}
