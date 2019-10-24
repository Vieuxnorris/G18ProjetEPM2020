package be.heh.entity;

import be.heh.entity.PaymentSchedule;

public class TwoWeeksPaymentSchedule implements PaymentSchedule {
    @Override
    public String choiceDate() {
        return "Vous serez payé tous les 2 vendredis";
    }
}
