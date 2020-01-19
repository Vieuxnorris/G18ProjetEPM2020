package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.Employee;

public class ChgEmpName extends ChgEmp {

    private String Name;

    public ChgEmpName(int empId, String name) {
        super(empId);
        this.Name = name;
    }

    @Override
    public void change(Employee employee) {
        employee.setName(Name);
    }
}
