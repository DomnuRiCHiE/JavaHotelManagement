package Factory;

import Domain.People.Client;
import Domain.People.Person;

public class ClientFactory extends PersonFactory{
    @Override
    public Person createPerson() {
        return new Client();
    }

    @Override
    public void unsubscribe() {

    }
}
