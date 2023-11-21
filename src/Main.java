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

        ClientRepository clientRepository = ClientRepository.getInstance();
        ClientController clientController = new ClientController(clientRepository);
        BookingRepository bookingRepository = BookingRepository.getInstance();
        BookingController bookingController = new BookingController(bookingRepository);
        HotelRepository hotelRepository = HotelRepository.getInstance();
        HotelController hotelController = new HotelController(hotelRepository);
        RoomRepository roomRepository = RoomRepository.getInstance();
        RoomController roomController = new RoomController(roomRepository);


        UI ui = new UI(bookingController,hotelController,roomController,clientController);
        ui.run();
    }
}
