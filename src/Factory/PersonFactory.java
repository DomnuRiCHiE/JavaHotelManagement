package Factory;

import Domain.People.Person;

abstract class PersonFactory implements Subscription {
    public void signUp(){
        createPerson();
    }

    public abstract Person createPerson();


}
