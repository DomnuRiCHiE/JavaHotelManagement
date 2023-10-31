package Domain.People;

public class Address {
    private String street;
    private int street_number;
    private int postal_number;
    private String city;
    private String country;

    public Address() {}

    public String getStreet() {return street;}

    public void setStreet(String street) {this.street = street;}

    public int getStreet_number() {return street_number;}

    public void setStreet_number(int street_number) {this.street_number = street_number;}

    public int getPostal_number() {return postal_number;}

    public void setPostal_number(int postal_number) {this.postal_number = postal_number;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}
}
