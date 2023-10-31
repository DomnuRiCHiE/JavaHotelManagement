package Domain.People;

public class Client extends Person {
    private boolean membership;
    private double amount_spent_at_hotel;

    public Client() {}

    public boolean isMembership() {return membership;}

    public void setMembership(boolean membership) {this.membership = membership;}

    public double getAmount_spent_at_hotel() {return amount_spent_at_hotel;}

    public void setAmount_spent_at_hotel(double amount_spent_at_hotel) {
        this.amount_spent_at_hotel = amount_spent_at_hotel;
    }
}
