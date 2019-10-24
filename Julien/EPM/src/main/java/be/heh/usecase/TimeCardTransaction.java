package be.heh.usecase;

import be.heh.entity.*;

import java.util.Calendar;

public class TimeCardTransaction implements Transaction {

    private int Empid;
    private Calendar Date;
    private double Hours;

    public TimeCardTransaction(int empid, Calendar date, double hours)
    {
        this.Empid = empid;
        this.Date = date;
        this.Hours = hours;
    }

    public void execute()
    {
        Employee e = PayrollDatabase.instance.getEmployee(Empid);
        if (e != null)
        {
            PaymentClassification pc = e.getClassification();
            if (pc instanceof HourlyClassification)
            {
                HourlyClassification hc = (HourlyClassification) pc;
                hc.addTimeCard(new TimeCard(Date, Hours));
            }
            else
            {
                throw new RuntimeException("Test 1");
            }
        }
        else
        {
            throw new RuntimeException("test 2");
        }
    }
}
