package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.DirectDepositMethod;
import be.heh.EPGMG5.entity.PaymentMethod;

public class ChgEmpDirect extends ChgEmpPayementMethod {

    private String Bank;
    private String Account;

    public ChgEmpDirect(int empId, String bank, String account) {
        super(empId);
        this.Bank = bank;
        this.Account = account;
    }

    @Override
    public PaymentMethod makePayementMethod() {
        return new DirectDepositMethod(Bank, Account);
    }

    /*    @Override
    public PaymentMethod getMethod() {
        return new DirectDepositMethod(bank, account);
    }*/
}
