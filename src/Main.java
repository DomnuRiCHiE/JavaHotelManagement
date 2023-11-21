import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.People.ClientController;
import Domain.People.Address;
import Domain.People.Admin;
import Domain.People.Client;
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
        Client client1 = new Client("bob","bob@gmail.com","0700800900",new Address(),"bobzob");
        Client client2 = new Client("zob","zob@gmail.com","0700810920",new Address(),"zobbob");
        clientController.add(client1);
        clientController.add(client2);
        BookingController bookingController = new BookingController(BookingRepository.getInstance());
        HotelController hotelController = new HotelController(HotelRepository.getInstance());
        RoomController roomController = new RoomController(RoomRepository.getInstance());

        UI ui = new UI(clientController, bookingController, hotelController, roomController);
        ui.run();
    }
}
