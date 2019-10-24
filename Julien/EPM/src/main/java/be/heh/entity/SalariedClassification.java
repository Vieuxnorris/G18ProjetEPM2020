package be.heh.entity;

import be.heh.entity.PaymentClassification;

public class SalariedClassification extends PaymentClassification {
	private double salary;

	public SalariedClassification(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return 1000;
	}

	public double calculationSalary(CheckPayment pc)
	{
		return salary;
	}
}
