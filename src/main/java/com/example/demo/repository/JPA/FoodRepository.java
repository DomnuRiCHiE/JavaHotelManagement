package com.example.demo.Repository.JPA;

import com.example.demo.Models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for Food JpaRepository
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {

}
