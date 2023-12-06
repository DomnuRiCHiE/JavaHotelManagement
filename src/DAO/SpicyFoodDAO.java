package DAO;

import Domain.Restaurant.FoodType;
import Domain.Restaurant.SpicyFood;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class SpicyFoodDAO implements IDAO<SpicyFood> {
    private static SpicyFoodDAO instance;
    private SpicyFoodDAO(){}

    public static SpicyFoodDAO getInstance() {
        if(instance == null) {
            instance = new SpicyFoodDAO();
        }
        return instance;
    }

    @Override
    public void addEntityDAO(SpicyFood spicyFood) {
        String name = spicyFood.getName();
        Double price = spicyFood.getPrice();
        String description = spicyFood.getDescription();
        Integer quantity = spicyFood.getQuantity();
        FoodType foodType = spicyFood.getFoodType();
        Integer spiceLevel = spicyFood.getSpiceLevel();

        try {
            String insertQuery = "INSERT INTO spicyFood (name, price, description, quantity, foodType, spiceLevel) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setDouble(2, price);
            insertStatement.setString(3, description);
            insertStatement.setInt(4, quantity);
            insertStatement.setString(5, foodType.name());
            insertStatement.setInt(6, spiceLevel);
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
    public void updateEntityDAO(SpicyFood spicyFood) {
        String name = spicyFood.getName();
        Double price = spicyFood.getPrice();
        String description = spicyFood.getDescription();
        Integer quantity = spicyFood.getQuantity();
        FoodType foodType = spicyFood.getFoodType();
        Integer spiceLevel = spicyFood.getSpiceLevel();

        try {
            String insertQuery = "UPDATE spicyFood SET price = ?, description = ?, quantity = ?, foodType = ?, spiceLevel = ? WHERE name = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setDouble(1, price);
            insertStatement.setString(2, description);
            insertStatement.setInt(3, quantity);
            insertStatement.setString(4, foodType.name());
            insertStatement.setInt(5, spiceLevel);
            insertStatement.setString(6, name);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntityDAO(SpicyFood spicyFood) {
        String name = spicyFood.getName();
        try {
            String insertQuery = "DELETE FROM spicyFood WHERE name = ?";
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
    public ArrayList<SpicyFood> getAllEntitiesDAO() {
        ArrayList<SpicyFood> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM spicyFood ORDER BY name;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                Integer quantity = resultSet.getInt("quantity");
                Integer spiceLevel = resultSet.getInt("spiceLevel");
                String foodTypeStr = resultSet.getString("foodType");
                FoodType foodType = FoodType.valueOf(foodTypeStr);

                SpicyFood spicyFood = new SpicyFood(name, price, description, quantity, foodType, spiceLevel);
                result.add(spicyFood);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(SpicyFood.getNullSpicyFood());
        return result;
    }
}
