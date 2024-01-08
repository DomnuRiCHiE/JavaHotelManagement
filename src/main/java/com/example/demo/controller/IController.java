package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

public interface IController<T, I> {
    ResponseEntity<T> add(T object);

    ResponseEntity<T> update(I id, T object);

    ResponseEntity<T> delete(I id);

    ResponseEntity<Entity> update(UUID id, Entity object);

    ResponseEntity<Entity> delete(UUID id);

    ResponseEntity<List<T>> getAll();

    ResponseEntity<T> getEntityById(I id);
}
