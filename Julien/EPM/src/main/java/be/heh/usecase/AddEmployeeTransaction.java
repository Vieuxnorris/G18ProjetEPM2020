package be.heh.usecase;

import be.heh.Context;
import be.heh.entity.*;

public abstract class AddEmployeeTransaction implements Command {
    private int empId;
    private String name;
    private String address;

    AddEmployeeTransaction(int empid, String name, String address) {
        this.empId = empid;
        this.address = address;
        this.name = name;
    }

    abstract PaymentClassification getClassification();
    abstract PaymentSchedule getSchedule();

    @Override
    public void execute() {
        Employee e = new Employee(empId, name, address);
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
        e.setMethod(new DirectDepositMethod("Fortis", "be332211"));
        PayrollDatabase.instance.addEmployee(empId, e);
    }
}
