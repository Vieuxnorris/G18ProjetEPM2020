package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.Context;
import be.heh.EPGMG5.entity.Command;

public class DeleteEmployee implements Command {

    private int EmpId;

    public DeleteEmployee(int empId) {
        this.EmpId = empId;
    }

    @Override
    public void execute() {
        Context.employeeGateway.deleteEmployee(EmpId);
    }
}
