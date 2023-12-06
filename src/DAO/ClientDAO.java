package DAO;

import Domain.People.Client;
import Domain.People.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Objects;

public class ClientDAO implements IDAO<Person> {
    private static ClientDAO instance;
    private ClientDAO(){}

    public static ClientDAO getInstance() {
        if(instance == null) {
            instance = new ClientDAO();
        }
        return instance;
    }

    @Override
    public void addEntityDAO(Person person) {
        String name = person.getName();
        String email = person.getEmail();
        String phoneNumber = person.getPhone_number();

        try {
            String insertQuery = "INSERT INTO person (name, email, phoneNumber) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setString(2, email);
            insertStatement.setString(3, phoneNumber);
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
    public void updateEntityDAO(Person person) {
        String name = person.getName();
        String email = person.getEmail();
        String phoneNumber = person.getPhone_number();
        try {
            String insertQuery = "UPDATE person SET name = ?, email = ? WHERE telephoneNumber = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setString(2, email);
            insertStatement.setString(3, phoneNumber);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntityDAO(Person person) {
        String phoneNumber = person.getPhone_number();
        try {
            String insertQuery = "DELETE FROM person WHERE phoneNumber = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, phoneNumber);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Person> getAllEntitiesDAO() {
        ArrayList<Person> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM person ORDER BY phoneNumber;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                Client client = new Client(name, email, phoneNumber);
                result.add(client);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Person.getNullPerson());
        return result;
    }

    public Person searchByPhoneNumber(String phoneNumber)
    {
        if (Objects.equals(phoneNumber, "null")) return Person.getNullPerson();
        try {
            String query = "SELECT * FROM person WHERE phoneNumber = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, phoneNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                return new Client(name, email, phoneNumber);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Person.getNullPerson();
    }
}
