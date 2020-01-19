package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.entity.PayCheck;

public class DirectDepositMethod implements PaymentMethod {

    private String Bank;
    private String Account;

    public DirectDepositMethod(String bank, String account) {
        this.Bank = bank;
        this.Account = account;
    }

    public String getBank() {
        return Bank;
    }

    public String getAccount() {
        return Account;
    }

    @Override
    public void pay(PayCheck pc) {
        pc.setField("Disposition", "Direct");
    }

    @Override
    public String toString() {
        return "direct deposit into Fortis : be332211";
    }
}
