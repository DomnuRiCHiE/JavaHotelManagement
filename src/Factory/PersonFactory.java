package Factory;

import Domain.People.Address;
import Domain.People.Client;
import Domain.People.Person;

public abstract class PersonFactory{
    public abstract Person createPerson(String name, String email, String phone_number, Address address);
    public void createPassword(Client client, String password){
        client.setPassword(password);
    }
}
