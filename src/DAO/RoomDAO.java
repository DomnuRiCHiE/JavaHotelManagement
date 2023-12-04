// Check again
package DAO;

import Domain.Hotel.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class RoomDAO implements IDAO<Room> {
    private static RoomDAO instance;
    private RoomDAO(){}

    public static RoomDAO getInstance() {
        if(instance == null) {
            instance = new RoomDAO();
        }
        return instance;
    }

    @Override
    public void addEntity(Room room) {
        Integer roomNumber = room.getRoomNumber();
        String roomType = room.getRoomType().toString();
        Integer numberOfBeds = room.getNumberOfBeds();
        Boolean occupied = room.isOccupied();
        Integer price = room.getPrice();

        try {
            String insertQuery = "INSERT INTO room (roomNumber, roomType, numberOfBeds, occupied, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, roomNumber);
            insertStatement.setString(2, roomType);
            insertStatement.setInt(3, numberOfBeds);
            insertStatement.setBoolean(4, occupied);
            insertStatement.setInt(5, price);
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
    public void updateEntity(Room room) {
        Integer roomNumber = room.getRoomNumber();
        String roomType = room.getRoomType().toString();
        Integer numberOfBeds = room.getNumberOfBeds();
        Boolean occupied = room.isOccupied();
        Integer price = room.getPrice();

        try {
            String insertQuery = "UPDATE room SET price = ?, roomType = ?, numberOfBeds = ?, occupied = ? WHERE roomNumber = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, price);
            insertStatement.setString(2, roomType);
            insertStatement.setInt(3, numberOfBeds);
            insertStatement.setBoolean(4, occupied);
            insertStatement.setInt(5, roomNumber);
            int rowsAffected = insertStatement.executeUpdate();
            if(rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Room room) {
        Integer roomNumber = room.getRoomNumber();
        try {
            String insertQuery = "DELETE FROM room WHERE roomNumber = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, roomNumber);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Object not in database");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Room> getAllEntities() {
        ArrayList<Room> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM room ORDER BY roomNumber;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Integer roomNumber = resultSet.getInt("roomNumber");
                //String roomType = resultSet.getString("roomType");
                Integer numberOfBeds = resultSet.getInt("numberOfBeds");
                Boolean occupied = resultSet.getBoolean("occupied");
                Integer price = resultSet.getInt("price");
                Room room = new Room(roomNumber, numberOfBeds, occupied, price);
                result.add(room);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Room.getNullRoom());
        return result;
    }
}
