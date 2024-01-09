package com.example.demo.Repository.JPA;

import com.example.demo.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for a Person JpaRepository
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

}
