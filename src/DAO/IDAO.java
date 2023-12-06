package DAO;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDAO<Entity> {
    Connection connection = DatabaseConnection.getConnection();
    void addEntityDAO(Entity entity);
    void updateEntityDAO(Entity entity);
    void deleteEntityDAO(Entity entity);
    ArrayList<Entity> getAllEntitiesDAO();
}
