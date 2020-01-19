package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.entity.PayCheck;

public class MailMethod implements PaymentMethod {

    private String Mail;

    public MailMethod(String mail) {
        this.Mail = mail;
    }

    public String getMail() {
        return Mail;
    }

    @Override
    public void pay(PayCheck pc) {
        pc.setField("Disposition", "Mail");
    }

    @Override
    public String toString() {
        return "mail : toto@gmail.com";
    }
}
