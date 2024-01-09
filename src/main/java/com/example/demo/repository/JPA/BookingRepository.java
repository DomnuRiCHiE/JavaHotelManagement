package com.example.demo.Repository.JPA;

import com.example.demo.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for a Booking JpaRepository
 */

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {

}
