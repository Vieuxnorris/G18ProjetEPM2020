package be.heh.entity;

import java.util.Calendar;

public class TimeCard extends HourlyClassification {
    private Calendar date;
    private double hours;

    public TimeCard(Calendar date, double hours)
    {
        super(hours);
        this.date = date;
        this.hours = hours;
    }

    public Calendar getDate()
    {
        return date;
    }

    public double getHours()
    {
        return hours;
    }
}
