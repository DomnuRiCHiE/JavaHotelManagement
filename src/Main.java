import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.People.ClientController;
import DAO.DatabaseConnection;
import Domain.People.Address;
import Domain.People.Admin;
import Domain.People.Client;
import Factory.ClientFactory;
import Repository.Hotel.BookingRepository;
import Repository.Hotel.HotelRepository;
import Repository.Hotel.RoomRepository;
import Repository.People.ClientRepository;
import UI.UI;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Admin admin = Admin.getInstance();
        admin.setPassword("password");

        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/hotel", "root", "vulpea25");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        ClientFactory factory = new ClientFactory();

        ClientController clientController = new ClientController(ClientRepository.getInstance());
        Client client1 = factory.createPerson("bob","bob@gmail.com","0700800900", new Address());
        factory.createPassword(client1,"bobzob");
        Client client2 = factory.createPerson("zob","zob@gmail.com","0700810920",new Address());
        factory.createPassword(client2,"zobbob");
        clientController.add(client1);
        clientController.add(client2);
        BookingController bookingController = new BookingController(BookingRepository.getInstance());
        HotelController hotelController = new HotelController(HotelRepository.getInstance());
        RoomController roomController = new RoomController(RoomRepository.getInstance());

        UI ui = new UI(clientController, bookingController, hotelController, roomController);
        ui.run();

    }
}
