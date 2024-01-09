package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

/**
 * Controller interface for implementing booking business logic
 * Extends BaseController
 * @param <Entity>
 * @param <IdType>
 */
@Service
public interface IController<Entity, IdType> {
    @PostMapping
    ResponseEntity<Entity> add(@RequestBody Entity object);

    @PutMapping("/{id}")
    ResponseEntity<Entity> update(@PathVariable(value = "id") IdType id, @RequestBody Entity object);

    @DeleteMapping("/{id}")
    ResponseEntity<Entity> delete(@PathVariable(value = "id") IdType id);

    @GetMapping
    ResponseEntity<List<Entity>> getAll();

    @GetMapping(("/{id}"))
    ResponseEntity<Entity> getEntityById(@PathVariable(value = "id") IdType id);
}
