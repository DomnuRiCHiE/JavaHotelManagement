package com.example.demo.Controller;

import com.example.demo.Service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public abstract class BaseController<Type, IdType> implements IController<Type, IdType>
{
    final BaseService<Type, IdType> service;
    public BaseController(BaseService<Type, IdType> service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Type> add(Type object) {
        try {
            Optional<Type> addedObject = service.add(object);
            return addedObject.map(type
                    -> ResponseEntity.status(HttpStatus.CREATED).body(type)).orElseGet(()
                    -> ResponseEntity.internalServerError().build()
            );
        } catch (Exception exception)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Entity> update(UUID id, Entity object) {
        try {
            Optional<Entity> oldObject = service.update(id, object);
            return oldObject.map(type
                    -> ResponseEntity.status(HttpStatus.OK).body(oldObject.get())).orElseGet(()
                    -> ResponseEntity.internalServerError().build()
            );
//        } catch (ChangeSetPersister.NotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); cand ai exceptie todo:fa aici
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Entity> delete(UUID id) {
        try {
            Optional<Entity> deletedObject = service.delete(id);
            return deletedObject.map(type
                    -> ResponseEntity.status(HttpStatus.OK).body(deletedObject.get())).orElseGet(()
                    -> ResponseEntity.internalServerError().build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<Type>> getAll() {
        return service.getAll()
                .map(list -> ResponseEntity.ok().body(list))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Type> getEntityById(IdType id) {
        return service.getEntityByKey(id)
                .map(equipmentItem -> ResponseEntity.ok().body(equipmentItem))
                .orElse(ResponseEntity.notFound().build());
    }
}
