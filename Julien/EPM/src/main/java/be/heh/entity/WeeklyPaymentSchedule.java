package be.heh.entity;

import be.heh.entity.PaymentSchedule;

public class WeeklyPaymentSchedule implements PaymentSchedule {
    @Override
    public String choiceDate() {
        return "Vous serez payé tous les vendredris";
    }
}
