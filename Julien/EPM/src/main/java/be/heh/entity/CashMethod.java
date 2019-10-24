package be.heh.entity;

import be.heh.entity.PaymentMethod;

public class CashMethod implements PaymentMethod {

    @Override
    public void pay(CheckPayment pc) {
        pc.setFields("Payement", "Cash");
    }
}