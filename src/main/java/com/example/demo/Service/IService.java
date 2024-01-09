package com.example.demo.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface for a common service behaviour
 * @param <E> the specific entity type
 * @param <I> the specific entity type identifier
 */

public interface IService<E, I> {
    Optional<E> add(E object) throws Exception;

    Optional<List<E>> getAll();

    Optional<E> getEntityByKey(I id);

    Optional<E> update(I id, E object) ;

    Optional<E> delete(I id) ;
}
