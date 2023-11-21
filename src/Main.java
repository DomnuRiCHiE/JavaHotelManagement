import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.People.ClientController;
import Domain.People.Admin;
import Repository.Hotel.BookingRepository;
import Repository.Hotel.HotelRepository;
import Repository.Hotel.RoomRepository;
import Repository.People.ClientRepository;
import UI.UI;

public class Main {
    public static void main(String[] args) {
        Admin admin = Admin.getInstance();
        admin.setPassword("password");


        ClientController clientController = new ClientController(ClientRepository.getInstance());
        BookingController bookingController = new BookingController(BookingRepository.getInstance());
        HotelController hotelController = new HotelController(HotelRepository.getInstance());
        RoomController roomController = new RoomController(RoomRepository.getInstance());

        UI ui = new UI(clientController, bookingController, hotelController, roomController);
        ui.run();
    }
}
