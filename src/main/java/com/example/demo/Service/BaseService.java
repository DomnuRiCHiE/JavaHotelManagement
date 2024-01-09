package com.example.demo.Service;

import com.example.demo.Repository.InMemory.IRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class BaseService<Entity, IdType> implements IService<Entity, IdType>
{
    protected final IRepository<Entity, IdType> repository;
    public BaseService(IRepository<Entity, IdType> repository)
    {
        this.repository = repository;
    }

    @Override
    public Optional<Entity> add(Entity object) throws Exception {
        if (repository.exists(Example.of(object))) throw new Exception();
        return Optional.of(repository.save(object));
    }

    @Override
    public Optional<List<Entity>> getAll() {
        List<Entity> list = repository.findAll();
        if (list.isEmpty()) return Optional.empty();
        Optional<List<Entity>> returnStatment = Optional.of(list);
        return returnStatment;
    }

    @Override
    public Optional<Entity> getEntityByKey(IdType id) {
        return repository.findById(id);
    }
}