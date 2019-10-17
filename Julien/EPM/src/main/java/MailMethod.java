public class MailMethod implements PaymentMethod {
    String Mail;

    public MailMethod(String m){
        this.Mail = m;
    }

    @Override
    public PaymentMethod getPayMethod() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mail : ").append(this.Mail);
        return sb.toString();
    }
}
