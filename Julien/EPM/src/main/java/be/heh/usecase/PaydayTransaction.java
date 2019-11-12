package be.heh.usecase;

import be.heh.entity.CheckPayment;
import be.heh.entity.Employee;
import be.heh.entity.PayrollDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PaydayTransaction  implements Transaction {

    private Calendar itsPayDate;
    private Map<Integer , CheckPayment> itsPayChecks;

    public PaydayTransaction (Calendar payDate)
    {
        this.itsPayDate = payDate;
        itsPayChecks = new HashMap<>();
    }

    public CheckPayment getPayCheck(int empID)
    {
        return itsPayChecks.get(empID);
    }

    public int getPayCheckCount()
    {
        return itsPayChecks.size();
    }

    @Override
    public void execute() {
        Set<Integer> empIds = PayrollDatabase.instance.getAllEmployeeIds();
        for (int id : empIds)
        {
            Employee e = PayrollDatabase.instance.getEmployee(id);
            if (e.PayDate(itsPayDate))
            {
                CheckPayment pc = new CheckPayment(e.getPayPeriodStartDay(itsPayDate), itsPayDate);
                itsPayChecks.put(id,pc);
                e.payment(pc);
            }
        }
    }
}
