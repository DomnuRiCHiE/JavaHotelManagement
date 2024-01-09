package com.example.demo.Repository.JPA;

import com.example.demo.Models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for a Restaurant JpaRepository
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

}
