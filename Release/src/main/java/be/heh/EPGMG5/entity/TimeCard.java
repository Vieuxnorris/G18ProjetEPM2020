package be.heh.EPGMG5.entity;

import java.util.Calendar;

public class TimeCard {
    private Calendar Date;
    private double Hours;

    public TimeCard(Calendar date, double hours) {
        this.Date = date;
        this.Hours = hours;
    }

    public Calendar getDate() {
        return Date;
    }

    public double getHours() {
        return Hours;
    }
}
