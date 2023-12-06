package Controller;

import DAO.IDAO;
import Repository.MainRepository;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class MainController<controllerType> implements IController<controllerType> {
    protected final MainRepository<controllerType> repository;

    protected final IDAO<controllerType> DAO_repo;

    protected Connection connection;

    protected MainController(MainRepository<controllerType> repository, IDAO<controllerType> DAO_repo) {
        this.repository = repository;
        this.DAO_repo = DAO_repo;
    }

    protected MainController(MainRepository<controllerType> repository){
        this.repository = repository;
        this.DAO_repo = null;
    }

    @Override
    public void add(controllerType object) {

        repository.add(object);
    }

    @Override
    public void update(controllerType object1, controllerType object2) {

        repository.update(object1,object2);
    }

    @Override
    public void delete(controllerType object) {
        repository.delete(object);
    }

    @Override
    public ArrayList<controllerType> getAll() {
        return repository.getAll();
    }
}
