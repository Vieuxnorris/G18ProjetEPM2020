package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.Context;
import be.heh.EPGMG5.entity.*;

abstract class AddEmp implements Command {

    protected Employee employee;
    private int EmpID;
    private String Address;
    private String Name;

    AddEmp(int empid, String name, String address) {
        this.EmpID = empid;
        this.Address = address;
        this.Name = name;
    }

    public abstract PaymentSchedule makePaymentSchedule();
    public abstract PaymentClassification makePaymentClassification();
    public abstract PaymentMethod makePaymentMethod();

    @Override
    public void execute() {
        Employee e = new Employee(EmpID, Name, Address);
        e.setPayClassification(makePaymentClassification());
        e.setPaySchedule(makePaymentSchedule());
        e.setPayMethod(new CashMethod());
        Context.employeeGateway.save(EmpID, e); // save a la place de addEmployee
    }

    /****************************************************/

/*    abstract PaymentClassification getClassification(); // faut remplacer par makePaymentClassification

    abstract PaymentSchedule getSchedule(); // faut remplacer par makePaymentSchedule*/
}
