package be.heh.entity;

import be.heh.entity.PaymentClassification;

import java.util.Calendar;
import java.util.HashMap;

public class CommissionedClassification extends PaymentClassification {
	private double salary;
	private double commission;
	private double commissionTotal;
	/*private HashMap<Calendar, SaleReceipt> listSaleReceipt;
	HashMap<Calendar, SaleReceipt> listSaleReceipt = new HashMap<Calendar, SaleReceipt>();*/

	@Override
	public double getSalary() {
		return 25;
	}

	public double calculationSalary(CheckPayment pc){
		return salary;
	}

	public void addSaleReceipt(SaleReceipt saleReceipt){

	}
}
