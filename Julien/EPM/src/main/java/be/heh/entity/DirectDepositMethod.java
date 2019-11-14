package be.heh.entity;

import be.heh.entity.PaymentMethod;

public class DirectDepositMethod implements PaymentMethod {
    private String BICaccount;
    private String bank;

    public DirectDepositMethod(String bank, String BICaccount) {
        this.bank = bank;
        this.BICaccount = BICaccount;
    }

    public String getBank() {
        return bank;
    }

    public String getBICaccount() {
        return BICaccount;
    }

    public void pay(CheckPayment pc)
    {
        pc.setFields("Disposition", "Direct");
    }

    @Override
    public String toString() {
        return "direct deposit into " + bank + " : " + BICaccount;
    }
}
