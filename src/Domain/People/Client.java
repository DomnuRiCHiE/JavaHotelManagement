package Domain.People;

import java.util.Objects;

public class Client extends Person{
    private boolean membership;

    public Client(String name, String email, String phone_number, Address address, String password) {
        this.password = password;
        this.setName(name);
        this.setEmail(email);
        this.setPhone_number(phone_number);
        this.setAddress(address);
        this.setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Client copy() {
        return new Client(name, email, phone_number, address, password);
    }

    @Override
    public boolean login(String username, String password) {
        if (!Objects.equals(username, this.name) || !Objects.equals(password, this.password)){
            System.out.println("Username or password not matching");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" +
                "membership=" + membership +
                ", amount_spent_at_hotel=" + amount_spent_at_hotel +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address=" + address +
                '}';
    }
}
