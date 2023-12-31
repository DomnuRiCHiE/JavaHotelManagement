package DAO;

import Domain.Restaurant.Food;
import Domain.Restaurant.FoodType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class FoodDAO implements IDAO<Food> {
    private static FoodDAO instance;
    private FoodDAO(){}

    public static FoodDAO getInstance() {
        if(instance == null) {
            instance = new FoodDAO();
        }
        return instance;
    }

    @Override
    public void addEntityDAO(Food food) {
        String name = food.getName();
        Double price = food.getPrice();
        String description = food.getDescription();
        Integer quantity = food.getQuantity();
        FoodType foodType = food.getFoodType();

        try {
            String insertQuery = "INSERT INTO food (name, price, description, quantity, foodType) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setDouble(2, price);
            insertStatement.setString(3, description);
            insertStatement.setInt(4, quantity);
            insertStatement.setString(5, foodType.name());
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
    public void updateEntityDAO(Food food) {
        String name = food.getName();
        Double price = food.getPrice();
        String description = food.getDescription();
        Integer quantity = food.getQuantity();
        FoodType foodType = food.getFoodType();

        try {
            String insertQuery = "UPDATE food SET price = ?, description = ?, quantity = ?, foodtype = ? WHERE name = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setDouble(1, price);
            insertStatement.setString(2, description);
            insertStatement.setInt(3, quantity);
            insertStatement.setString(4, foodType.name());
            insertStatement.setString(5, name);

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntityDAO(Food food) {
        String name = food.getName();
        try {
            String insertQuery = "DELETE FROM food WHERE name = ?";
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
    public ArrayList<Food> getAllEntitiesDAO() {
        ArrayList<Food> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM food ORDER BY name;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                Integer quantity = resultSet.getInt("quantity");
                String foodTypeStr = resultSet.getString("foodType");
                FoodType foodType = FoodType.valueOf(foodTypeStr);

                Food food = new Food(name, price, description, quantity, foodType);
                result.add(food);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Food.getNullFood());
        return result;
    }
}
