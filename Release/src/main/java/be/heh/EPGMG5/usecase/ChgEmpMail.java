package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.MailMethod;
import be.heh.EPGMG5.entity.PaymentMethod;

public class ChgEmpMail extends ChgEmpPayementMethod {

    private String Mail;

    public ChgEmpMail(int empId, String mail) {
        super(empId);
        this.Mail = mail;
    }

    @Override
    public PaymentMethod makePayementMethod() {
        return new MailMethod(Mail);
    }

    /*    @Override
    public PaymentMethod getMethod() {
        return new MailMethod(Mail);
    }*/
}
