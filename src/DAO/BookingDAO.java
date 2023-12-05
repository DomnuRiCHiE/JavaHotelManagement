package DAO;

import Domain.Hotel.Booking;
import Domain.Hotel.Room;
import Domain.Hotel.RoomCategories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BookingDAO implements IDAO<Booking> {
    private static BookingDAO instance;
    private BookingDAO(){}

    public static BookingDAO getInstance() {
        if(instance == null) {
            instance = new BookingDAO();
        }
        return instance;
    }

    @Override
    public void addEntity(Booking booking) {
        try {
            String insertQuery = "INSERT INTO booking (id, client_name, payment_method) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, booking.getID());
            insertStatement.setString(2, booking.getClient().getName());
            insertStatement.setString(3, booking.getPaymentMethod().name());
            insertStatement.executeUpdate();
            addRoomsToBooking(booking, booking.getBookedRooms());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Booking booking) {
        try {
            String updateQuery = "UPDATE booking SET client_id = ?, payment_method = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, booking.getClient().getName());
            updateStatement.setString(2, booking.getPaymentMethod().name());
            updateStatement.setString(3, booking.getID());
            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Booking not in database");

            removeRoomsFromBooking(booking);
            addRoomsToBooking(booking, booking.getBookedRooms());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Booking booking) {
        try {
            removeRoomsFromBooking(booking);

            String deleteQuery = "DELETE FROM booking WHERE id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, booking.getID());
            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected == 0) throw new RuntimeException("Booking not in database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Booking> getAllEntities() {
        ArrayList<Booking> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM booking";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String bookingId = resultSet.getString("id");
                Set<Room> bookedRooms = getBookedRoomsForBooking(bookingId);
                Set<Room> roomSet = new HashSet<>(bookedRooms);
                Booking booking = new Booking();
                booking.setID(bookingId);
                booking.setBookedRooms(roomSet);
                result.add(booking);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Set<Room> getBookedRoomsForBooking(String bookingId) {
        Set<Room> bookedRooms = new HashSet<>();
        try {
            String query = "SELECT room_id FROM booking_room WHERE booking_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, bookingId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int roomNumber = resultSet.getInt("room_id");
                Room room = getRoomByNumber(roomNumber);
                bookedRooms.add(room);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookedRooms;
    }

    private Room getRoomByNumber(int roomNumber) {
        try {
            String query = "SELECT * FROM room WHERE roomNumber = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, roomNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                RoomCategories roomType = RoomCategories.valueOf(resultSet.getString("roomType"));
                int numberOfBeds = resultSet.getInt("numberOfBeds");
                boolean occupied = resultSet.getBoolean("occupied");
                int price = resultSet.getInt("price");

                return new Room(roomNumber, roomType, numberOfBeds, occupied, price);
            } else {
                throw new RuntimeException("Room not found in the database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void removeRoomsFromBooking(Booking booking) {
        try {
            String deleteQuery = "DELETE FROM booking_room WHERE booking_id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, booking.getID());
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addRoomsToBooking(Booking booking, Set<Room> rooms) {
        try {
            String insertQuery = "INSERT INTO booking_room (booking_id, room_id) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

            for (Room room : rooms) {
                insertStatement.setString(1, booking.getID());
                insertStatement.setInt(2, room.getRoomNumber());
                insertStatement.addBatch();
            }

            insertStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
