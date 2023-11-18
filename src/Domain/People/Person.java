package Domain.People;

public abstract class Person implements Login {
    protected String name;
    protected String email;
    protected String phone_number;
    protected Address address;

    protected String password;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhone_number() {return phone_number;}

    public void setPhone_number(String phone_number) {this.phone_number = phone_number;}

    public Address getAddress() {return address;}

    public void setAddress(Address address) {this.address = address;}

    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
