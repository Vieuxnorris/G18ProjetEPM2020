public class DirectDepositMethod implements PaymentMethod {
    public String Bank;
    public String Account;

    public DirectDepositMethod(String b, String a){

        this.Bank = b;
        this.Account = a;
    }

    @Override
    public PaymentMethod getPayMethod() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("direct deposit into ").append(this.Bank);
        sb.append(" : ").append(this.Account);
        return sb.toString();
    }
}
