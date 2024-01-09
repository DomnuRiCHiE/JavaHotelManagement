package com.example.demo.Repository.JPA;

import com.example.demo.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * interface for an Employee JpaRepository
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
