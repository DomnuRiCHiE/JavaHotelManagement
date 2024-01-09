package com.example.demo.Proxy;

import com.example.demo.Models.Room;
import com.example.demo.Repository.InMemory.IRepository;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public abstract class ProxyRepository<Entity, Id> implements IRepository<Entity, Id>
{
    protected IRepository<Entity, Id> currentRepo;

    public abstract void selectInMemory();

    @Override
    public <E extends Entity> E save(E entity) {
        return currentRepo.save(entity);
    }

    @Override
    public void deleteById(Id id) {
        currentRepo.deleteById(id);
    }

    @Override
    public <E extends Entity> boolean exists(Example<E> entity) {
        return currentRepo.exists(entity);
    }

    @Override
    public Optional<Entity> findById(Id id) {
        return currentRepo.findById(id);
    }

    @Override
    public List<Entity> findAll() {
        return currentRepo.findAll();
    }

    @Override
    public boolean existsById(Id id) {
        return currentRepo.existsById(id);
    }

    public abstract Optional<List<Room>> findByName(String name);
}
