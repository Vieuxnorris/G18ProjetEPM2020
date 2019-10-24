package be.heh.entity;

import be.heh.entity.PaymentMethod;

public class MailMethod implements PaymentMethod {
	private String mail;

	public MailMethod(String mail) {
		this.mail = mail;
	}


	@Override
	public void pay(CheckPayment pc) {
		pc.setFields("payement : ", "Mail");
	}

	@Override
	public String toString() {
		return "mail : " + mail;
	}
}