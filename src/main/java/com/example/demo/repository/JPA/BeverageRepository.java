package com.example.demo.Repository.JPA;

import com.example.demo.Models.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for a Beverage JpaRepository
 */

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, UUID> {

}
