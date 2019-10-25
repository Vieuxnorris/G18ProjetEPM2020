package be.heh.usecase;

import be.heh.entity.Employee;
import be.heh.entity.PayrollDatabase;

abstract class ChangeEmployeeTransaction implements Transaction {

    private int EmpID;

    public ChangeEmployeeTransaction(int empID)
    {
        this.EmpID = empID;
    }

    public abstract void change(Employee employee);

    @Override
    public void execute() {
        Employee e = PayrollDatabase.instance.getEmployee(EmpID);
        if (e != null)
        {
            change(e);
        }
    }
}
