package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.CashMethod;
import be.heh.EPGMG5.entity.PaymentMethod;

public class ChgEmpCash extends ChgEmpPayementMethod {

    public ChgEmpCash(int EmpId) {
        super(EmpId);
    }

    @Override
    public PaymentMethod makePayementMethod() {
        return new CashMethod();
    }

/*    @Override
    public PaymentMethod getMethod() {
        return new CashMethod();
    }*/
}
