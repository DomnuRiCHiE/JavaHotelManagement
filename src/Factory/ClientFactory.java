package Factory;

import Domain.People.Address;
import Domain.People.Client;
import Domain.People.Person;

public class ClientFactory extends PersonFactory{


    @Override
    public Client createPerson(String name, String email, String phone_number, Address address) {
        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setAddress(address);
        client.setPhone_number(phone_number);
        return client;
    }
}
