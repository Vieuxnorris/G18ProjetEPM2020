package be.heh.entity;

import be.heh.entity.PaymentClassification;
import be.heh.entity.TimeCard;

import java.util.Calendar;
import java.util.HashMap;

public class HourlyClassification extends PaymentClassification {
	private double hoursSalary;
	private double salary;
	private HashMap<Calendar, TimeCard> listTimeCard;


	public HourlyClassification(double hoursSalary){
		this.hoursSalary = hoursSalary;
		listTimeCard = new HashMap<>();
	}

	public double getSalary()
	{
		return salary;
	}

    public double calculationSalary(CheckPayment pc){
		double totalpay = 0;
		for (TimeCard timeCard: listTimeCard.values())
		{
			if (PayPeriod(timeCard.getDate(), pc))
			{
				totalpay += CalculPayTimeCard(timeCard);
			}
		}
		return totalpay;
	}

	private double CalculPayTimeCard(TimeCard timeCard)
	{
		double hours = timeCard.getHours();
		double overtime = Math.max(0.0, hours-8.0);
		double straightTime = hours - overtime;
		return straightTime * salary + overtime * salary * 1.5;
	}

	public void addTimeCard(TimeCard timeCard) {
		listTimeCard.put(timeCard.getDate(), timeCard);
	}

	public TimeCard getTimeCard(Calendar date)
	{
		return listTimeCard.get(date);
	}
}
