package Controller;

import java.util.ArrayList;

public interface IController<T> {
    public void add(T object);
    public void update(T object1, T object2);
    public void delete(T object);
    public ArrayList<T> getAll();
}
