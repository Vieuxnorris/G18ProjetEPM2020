package be.heh.entity;

import be.heh.entity.PaymentSchedule;

import java.util.Calendar;

public class MonthlyPaymentySchedule implements PaymentSchedule {

     @Override
     public boolean isPayday(Calendar date) {
         return ;
     }
}
