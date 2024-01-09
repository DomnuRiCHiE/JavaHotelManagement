package com.example.demo.Repository.JPA;

import com.example.demo.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for an Item JpaRepository
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

}
