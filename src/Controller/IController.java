package Controller;

import java.util.ArrayList;

public interface IController<T> {
    void add(T object);
    void update(T object1, T object2);
    void delete(T object);
    ArrayList<T> getAll();
}
