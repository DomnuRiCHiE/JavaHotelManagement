package DAO;

import Domain.Restaurant.AlcoholicBeverages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class AlcoholicBeverageDAO implements IDAO<AlcoholicBeverages> {
    private static AlcoholicBeverageDAO instance;
    private AlcoholicBeverageDAO(){}

    public static AlcoholicBeverageDAO getInstance() {
        if(instance == null) {
            instance = new AlcoholicBeverageDAO();
        }
        return instance;
    }

    @Override
    public void addEntityDAO(AlcoholicBeverages alcoholicBeverage) {
        String name = alcoholicBeverage.getName();
        Double price = alcoholicBeverage.getPrice();
        String description = alcoholicBeverage.getDescription();
        Integer volume = alcoholicBeverage.getVolume();
        Integer alcoholPercentage = alcoholicBeverage.getAlcoholPercentage();



        try {
            String insertQuery = "INSERT INTO alcoholicBeverages (name, price, description, volume, alcoholPercentage) VALUES (?, ?, ?, ? ,?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setDouble(2, price);
            insertStatement.setString(3, description);
            insertStatement.setInt(4, volume);
            insertStatement.setInt(5, alcoholPercentage);
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
    public void updateEntityDAO(AlcoholicBeverages alcoholicBeverage) {
        String name = alcoholicBeverage.getName();
        Double price = alcoholicBeverage.getPrice();
        String description = alcoholicBeverage.getDescription();
        Integer volume = alcoholicBeverage.getVolume();
        Integer alcoholPercentage = alcoholicBeverage.getAlcoholPercentage();

        try {
            String insertQuery = "UPDATE alcoholicBeverages SET price = ?, description = ?, volume = ?, alcoholPercentage = ? WHERE name = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setDouble(1, price);
            insertStatement.setString(2, description);
            insertStatement.setInt(3, volume);
            insertStatement.setInt(4, alcoholPercentage);
            insertStatement.setString(5, name);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntityDAO(AlcoholicBeverages alcoholicBeverage) {
        String name = alcoholicBeverage.getName();
        try {
            String insertQuery = "DELETE FROM alcoholicBeverages WHERE name = ?";
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
    public ArrayList<AlcoholicBeverages> getAllEntitiesDAO() {
        ArrayList<AlcoholicBeverages> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM alcoholicBeverages ORDER BY name;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                Integer volume = resultSet.getInt("volume");
                Integer alcoholPercentage = resultSet.getInt("alcoholPercentage");
                AlcoholicBeverages alcoholicBeverage = new AlcoholicBeverages(name, price, description, volume, alcoholPercentage);
                result.add(alcoholicBeverage);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(AlcoholicBeverages.getNullAlcoholicBeverage());
        return result;
    }
}
