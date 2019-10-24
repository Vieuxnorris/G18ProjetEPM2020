package be.heh.usecase;

import be.heh.entity.*;

public class AddHourlyEmployee extends AddEmployeeTransaction {

    private double hrly_rate;

    public AddHourlyEmployee(int empId, String name, String address, double hrly_rate){
        super(empId, name, address);
        this.hrly_rate = hrly_rate;
    }

    @Override
    PaymentClassification getClassification() {
        return new HourlyClassification(hrly_rate);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new WeeklyPaymentSchedule();
    }
}
