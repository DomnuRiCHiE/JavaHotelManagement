package Repository;

import java.util.ArrayList;

public interface IRepository<T> {
    public void add(T object);
    public void update(T object);
    public void delete(T object);
    public ArrayList<T> getAll();
}