import java.util.Calendar;

public class TimeCard {
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public double getHours() {
        return Hours+0.5;
    }

    public void setHours(double hours) {
        Hours = hours;
    }

    private Calendar date;
    private double Hours;

    public TimeCard (Calendar c, double h){
        this.date = c;
        this.Hours = h;
    }


}
