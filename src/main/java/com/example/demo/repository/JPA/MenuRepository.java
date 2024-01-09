package com.example.demo.Repository.JPA;

import com.example.demo.Models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for a Menu JpaRepository
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {

}
