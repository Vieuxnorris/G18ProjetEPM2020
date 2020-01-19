package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.Context;
import be.heh.EPGMG5.entity.Employee;
import be.heh.EPGMG5.entity.PayCheck;
import be.heh.EPGMG5.entity.Command;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Payday implements Command {

    private Calendar itsPayDate;
    private Map<Integer, PayCheck> itsPaychecks;

    public Payday(Calendar payDate) {
        this.itsPayDate = payDate;
        itsPaychecks = new HashMap<>();
    }

    public PayCheck getPaycheck(int empId) {
        return itsPaychecks.get(empId);
    }

    public int getPayCheckCount() {
        return itsPaychecks.size();
    }

    @Override
    public void execute() {
        Set<Integer> empIds = Context.employeeGateway.getAllEmployeeIds();
        for (int id : empIds) {
            Employee e = Context.employeeGateway.getEmployee(id);
            if (e.isPayDate(itsPayDate)) {
                PayCheck pc = new PayCheck(e.getPayPeriodStartDay(itsPayDate), itsPayDate);
                itsPaychecks.put(id, pc);
                e.payday(pc);
            }
        }
    }
}
