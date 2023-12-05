package DAO;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDAO<Entity> {
    Connection connection = DatabaseConnection.getConnection();
    void addEntity(Entity entity);
    void updateEntity(Entity entity);
    void deleteEntity(Entity entity);
    ArrayList<Entity> getAllEntities();
}
