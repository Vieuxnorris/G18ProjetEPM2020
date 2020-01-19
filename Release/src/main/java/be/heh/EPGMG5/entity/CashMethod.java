package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.entity.PayCheck;
import be.heh.EPGMG5.entity.PaymentMethod;

public class CashMethod implements PaymentMethod {

    @Override
    public void pay(PayCheck pc) {
        pc.setField("Disposition", "Hold");
    }
}
