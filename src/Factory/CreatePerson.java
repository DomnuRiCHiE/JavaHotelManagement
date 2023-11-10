package Factory;

import Domain.People.Address;
import Domain.People.Person;

public interface CreatePerson {
    public Person createPerson(String name, String email, String phone_number, Address address  );
}
