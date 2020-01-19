package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.entity.PayCheck;

public interface PaymentMethod {
    void pay(PayCheck pc);
}
