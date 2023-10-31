package Domain.People;

public class Client extends Person {
    private boolean membership;
    private double amount_spent_at_hotel;

    public Client() {}

    @Override
    public String getName() {return super.getName();}

    @Override
    public void setName(String name) {super.setName(name);}

    @Override
    public String getEmail() {return super.getEmail();}

    @Override
    public void setEmail(String email) {super.setEmail(email);}

    @Override
    public String getPhone_number() {return super.getPhone_number();}

    @Override
    public void setPhone_number(String phone_number) {super.setPhone_number(phone_number);}

    @Override
    public Address getAddress() {return super.getAddress();}

    @Override
    public void setAddress(Address address) {super.setAddress(address);}

    public boolean isMembership() {return membership;}

    public void setMembership(boolean membership) {this.membership = membership;}

    public double getAmount_spent_at_hotel() {return amount_spent_at_hotel;}

    public void setAmount_spent_at_hotel(double amount_spent_at_hotel) {
        this.amount_spent_at_hotel = amount_spent_at_hotel;
    }
}