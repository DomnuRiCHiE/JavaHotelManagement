package com.example.demo.Service;

import com.example.demo.Models.Person;
import com.example.demo.Repository.InMemory.IRepository;
import com.example.demo.Repository.JPA.PersonRepository;

import java.util.UUID;

/**
 * Service for extracting Person repository info
 */

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class PersonService<PersonType extends Person> extends BaseService<PersonType, UUID> {
    private final PersonRepository personRepository;

    public PersonService(IRepository<PersonType, UUID> repository, PersonRepository personRepository) {
        super(repository);
        this.personRepository = personRepository;
    }
}
