package be.heh.entity;

import be.heh.entity.PaymentMethod;

public class CashMethod implements PaymentMethod {

    @Override
    public void pay(CheckPayment pc) {
        pc.setFields("Disposition", "Cash");
    }

    @Override
    public String toString() {
        return "Payement en cash";
    }
}