package Factory;

import Domain.People.Address;
import Domain.People.Client;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class ClientFactoryTest {

    private ClientFactory factory;

    @org.junit.jupiter.api.Test
    void createPassword() {
        Client test = createPerson();
        String password = "testpassword";
        factory.createPassword(test, password);
        assertEquals(test.getPassword(), password);
    }

    @org.junit.jupiter.api.Test
    Client createPerson() {
        this.factory = new ClientFactory();
        String name = "Ion Popescu";
        String email = "ion@gmail.com";
        String phone_number = "0700800900";
        Address address = new Address();
        address.setStreet("Str. Ploiesti");
        address.setStreet_number(27);
        address.setCity("Cluj-Napoca");
        address.setCountry("Romania");
        address.setPostal_number(560890);
        String password = "testpassword";
        Client testclient = new Client(name,email,phone_number,address,password);
        Client product = factory.createPerson(name,email,phone_number,address);
        assertEquals(testclient.getName(),product.getName());
        assertEquals(testclient.getEmail(), product.getEmail());
        assertEquals(testclient.getPhone_number(), product.getPhone_number());
        assertEquals(testclient.getAddress(), product.getAddress());
        return product;
    }
}