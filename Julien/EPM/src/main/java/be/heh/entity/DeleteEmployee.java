package be.heh.entity;

import be.heh.Context;

public class DeleteEmployee implements Command
{
    private int empID;

    public DeleteEmployee(int empID){
        this.empID = empID;
    }

    @Override
    public void execute() {
        Context.employeeGateway.deleteEmployee(empID);
    }
}
