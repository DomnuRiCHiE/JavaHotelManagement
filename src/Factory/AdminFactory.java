package Factory;

import Domain.People.Address;
import Domain.People.Admin;

public class AdminFactory extends PersonFactory {
    @Override
    public Admin createPerson(String name, String email, String phone_number, Address address) {
        return null;
    }
}
