package com.example.demo.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IService<E, I> {
    Optional<E> add(E object);

    Optional<List<E>> getAll();

    Optional<E> getEntityByKey(I id);

    Optional<Entity> update(UUID id, Entity object) ;

    Optional<Entity> delete(UUID id) ;
}
