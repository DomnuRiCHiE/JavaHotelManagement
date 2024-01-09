package com.example.demo.Repository.JPA;

import com.example.demo.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for a Client JpaRepository
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

}
