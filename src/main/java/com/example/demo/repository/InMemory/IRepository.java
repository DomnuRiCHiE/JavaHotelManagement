package com.example.demo.Repository.InMemory;

import org.springframework.data.domain.Example;
import java.util.List;
import java.util.Optional;

/**
 * Common interface for repositories to implement common methods for all CRUD operations
 * Includes all CRUD methods
 * @param <Entity> the type of entity
 * @param <ID> the entity type identifier
 */

public interface IRepository<Entity, ID> {
    <E extends Entity> E save(E entity);

    <E extends Entity> boolean exists(Example<E> entity);

    List<Entity> findAll();

    boolean existsByID(ID id);

    void deleteById(ID id);

    Optional<Entity> findById(ID id);

    boolean existsById(ID id);
}
