package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.Command;
import be.heh.EPGMG5.entity.Employee;
import be.heh.EPGMG5.Context;


abstract class ChgEmp implements Command {

    private int EmpId;

    public ChgEmp(int empId) {
        this.EmpId = empId;
    }

    public abstract void change(Employee employee);

    @Override
    public void execute() {
        Employee e = Context.employeeGateway.getEmployee(EmpId);
        if (e != null) {
            change(e);
        }
    }
}
