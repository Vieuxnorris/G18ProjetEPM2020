package be.heh.entity;

import be.heh.Context;
import be.heh.entity.Command;

public abstract class AddEmployee implements Command {

    private int itsEmpid;
    private String itsAddress;
    private String itsName;

    AddEmployee(int empid, String name, String address) {
        this.itsEmpid = empid;
        this.itsAddress = address;
        this.itsName = name;
    }

    abstract PaymentClassification getClassification();

    abstract PaymentSchedule getSchedule();
    @Override
    public void execute() {
        Employee e = new Employee(itsEmpid, itsName, itsAddress);
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
        e.setMethod(new CashMethod());
        PayrollDatabase.instance.addEmployee(itsEmpid, e);

    }

}
