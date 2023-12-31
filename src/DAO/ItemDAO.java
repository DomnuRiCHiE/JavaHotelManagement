package DAO;

import Domain.Restaurant.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ItemDAO implements IDAO<Item> {
    private static ItemDAO instance;
    private ItemDAO(){}

    public static ItemDAO getInstance() {
        if(instance == null) {
            instance = new ItemDAO();
        }
        return instance;
    }

    @Override
    public void addEntityDAO(Item item) {
        String name = item.getName();
        Double price = item.getPrice();
        String description = item.getDescription();

        try {
            String insertQuery = "INSERT INTO item (name, price, description) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setDouble(2, price);
            insertStatement.setString(3, description);
            insertStatement.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("Object already in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntityDAO(Item item) {
        String name = item.getName();
        Double price = item.getPrice();
        String description = item.getDescription();

        try {
            String insertQuery = "UPDATE item SET price = ?, description = ? WHERE name = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setDouble(1, price);
            insertStatement.setString(2, description);
            insertStatement.setString(3, name);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntityDAO(Item item) {
        String name = item.getName();
        try {
            String insertQuery = "DELETE FROM item WHERE name = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Item> getAllEntitiesDAO() {
        ArrayList<Item> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM item ORDER BY name;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                Item item = new Item(name, price, description);
                result.add(item);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Item.getNullItem());
        return result;
    }
}
