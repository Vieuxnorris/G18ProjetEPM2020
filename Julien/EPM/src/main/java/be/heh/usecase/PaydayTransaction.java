package be.heh.usecase;

import be.heh.entity.CheckPayment;
import be.heh.entity.Employee;
import be.heh.entity.PayrollDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PaydayTransaction  implements Transaction {

    private Calendar PayDate;
    private Map<Integer , CheckPayment> PayChecks;

    public PaydayTransaction (Calendar payDate)
    {
        this.PayDate = payDate;
        PayChecks = new HashMap<>();
    }

    public CheckPayment getPayCheck(int empID)
    {
        return PayChecks.get(empID);
    }

    public int getPayCheckCount()
    {
        return PayChecks.size();
    }

    @Override
    public void execute() {
        Set<Integer> empIds = PayrollDatabase.instance.getAllEmployeeIds();
        for (int id : empIds)
        {
            Employee e = PayrollDatabase.instance.getEmployee(id);
            if (e.PayDate(PayDate))
            {
                CheckPayment pc = new CheckPayment(e.getPayPeriodStartDay(PayDate), PayDate);
                PayChecks.put(id,pc);
                e.payment(pc);
            }
        }
    }
}
