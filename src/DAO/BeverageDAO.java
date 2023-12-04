package DAO;

import Domain.Restaurant.Beverage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class BeverageDAO implements IDAO<Beverage> {
    private static BeverageDAO instance;
    private BeverageDAO(){}

    public static BeverageDAO getInstance() {
        if(instance == null) {
            instance = new BeverageDAO();
        }
        return instance;
    }

    @Override
    public void addEntity(Beverage beverage) {
        String name = beverage.getName();
        Double price = beverage.getPrice();
        String description = beverage.getDescription();
        Integer volume = beverage.getVolume();

        try {
            String insertQuery = "INSERT INTO beverage (name, price, description, volume) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setDouble(2, price);
            insertStatement.setString(3, description);
            insertStatement.setInt(4, volume);
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
    public void updateEntity(Beverage beverage) {
        String name = beverage.getName();
        Double price = beverage.getPrice();
        String description = beverage.getDescription();
        Integer volume = beverage.getVolume();

        try {
            String insertQuery = "UPDATE beverage SET price = ?, description = ?, volume = ? WHERE name = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setDouble(1, price);
            insertStatement.setString(2, description);
            insertStatement.setInt(3, volume);
            insertStatement.setString(4, name);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Beverage beverage) {
        String name = beverage.getName();
        try {
            String insertQuery = "DELETE FROM beverage WHERE name = ?";
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
    public ArrayList<Beverage> getAllEntities() {
        ArrayList<Beverage> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM beverages ORDER BY name;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                Integer volume = resultSet.getInt("volume");
                Beverage beverage = new Beverage(name, price, description, volume);
                result.add(beverage);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Beverage.getNullBeverage());
        return result;
    }
}
