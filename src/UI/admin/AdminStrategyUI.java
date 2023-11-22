package UI.admin;

import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.Observer.Observers.ObserverRoomOccupancy;
import Controller.Observer.Subjects.SubjectRoomOccupancy;
import Controller.People.ClientController;
import Domain.Hotel.Room;
import Domain.Hotel.RoomCategories;
import Domain.People.Admin;
import Domain.People.Client;
import UI.ReturnInput;
import UI.UIStrategy;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AdminStrategyUI implements ReturnInput, UIStrategy {
    private String adminContextMenuActions;

    private ClientController clientController;

    private BookingController bookingController;
    private HotelController hotelController;
    private RoomController roomController;

    private Admin admin;

    public AdminStrategyUI(BookingController bookingController, HotelController hotelController, RoomController roomController, ClientController clientController) {
        this.admin = Admin.getInstance();
        this.adminContextMenuActions = "----------------Admin Menu------------------\n" +
                "1. getClientsInfoList\n" +
                "2. modifyClient\n" +
                "3. searchBookingByClientName\n" +
                "4. assignRestaurantToHotel\n" +
                "5. manageRestaurant\n" +
                "6. modifyBookingInfo\n" +
                "7. deleteClientFromHotel\n" +
                "8. deleteRoomFromHotel\n" +
                "9. manageRoom\n" +
                "10. addRoomToHotel\n" +
                "11. observer pattern\n" +
                "12. Go back";
        this.clientController = clientController;
        this.bookingController = bookingController;
        this.hotelController = hotelController;
        this.roomController = roomController;
    }

    public void run() {
        while (true) {
            System.out.println(this.adminContextMenuActions);
            String option = returnInput();
            if (Objects.equals(option,"12")){
                break;
            }
            switch (option) {
                case "1": getClientsInfoList(); break;
                case "2": updateClient(); break;
                case "3": searchBookingByClientName(); break;
                case "4": assignRestaurantToHotel(); break;
                case "5": manageRestaurant(); break;
                case "6": updateBookingInfo(); break;
                case "7": deleteClientFromHotel(); break;
                case "8": deleteRoomFromHotel(); break;
                case "9": manageRoom(); break;
                case "10": addRoomToHotel(); break;
                case "11": observerPattern(); break;
                default: break;
            }
        }
    }

    public void observerPattern() {
        SubjectRoomOccupancy subjectRoomOccupancy = new SubjectRoomOccupancy();
        ObserverRoomOccupancy observerRoomOccupancy = new ObserverRoomOccupancy();

        subjectRoomOccupancy.addObserver(observerRoomOccupancy);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. Make a change to notify the observers");
            System.out.println("2. See the last update");
            System.out.println("3. Exit");

            System.out.println("What's your choice: ");
            int choice = scanner.nextInt();

            Room room = new Room(1, RoomCategories.STUDIO, 2, 50);

            switch (choice) {
                case 1:
                    System.out.println("Enter the new room occupancy status (true/false): ");
                    boolean newStatus = scanner.nextBoolean();
                    subjectRoomOccupancy.setRoomOccupancy(room, newStatus);
                    observerRoomOccupancy.updateRoomOccupancy(room);
                    break;
                case 2:
                    System.out.println(observerRoomOccupancy.getLastUpdate());
                    break;
                case 3:
                    System.out.println("Exiting the observer pattern example.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    public void assignRestaurantToHotel() {
        System.out.println("Under Construction");
    }
    public void manageRestaurant() {
        System.out.println("Under Construction");
    }// uses ManageRestaurantUI
    public void manageRoom(){
        System.out.println("Under Construction");
    } // uses ManageRoomUI
    public void getClientsInfoList() {
        Client client = searchClientByName();
        System.out.println(clientController.getClientInfoList(client));
    }
    public Client searchClientByName() {
        System.out.println("Client name: ");
        String name = returnInput();
        ArrayList<Client> clients = clientController.getAll();
        Client client_to_be_changed = new Client();
        for (Client client : clients){
            if (Objects.equals(client.getName(), name)){
                client_to_be_changed = client;
                break;
            }
        }
        return client_to_be_changed;
    }
    public void addRoomToHotel() {
        System.out.println("Under Construction");
//        System.out.println("Room number: ");
//        int number =  Integer.parseInt(returnInput());
////      try catch  search room number in controller to see if it exists: update/fail?
//        System.out.println("Room type: ");
//        String type = returnInput();
////      try catch  RoomCategories room_type = changeToRoomCategory(type);
//        System.out.println("Number of beds: ");
//        int beds = Integer.parseInt(returnInput());
//        System.out.println("Room price: ");
//        int price = Integer.parseInt(returnInput());
////      try catch  controller.addRoom(number,type,beds,price)
    }
    public void deleteRoomFromHotel() {
        System.out.println("Room number: ");
//      try catch  controller.deleteRoom(Integer.parseInt(returnInput));
    }
    public void deleteClientFromHotel() {
        Client client_to_be_changed = searchClientByName();
        clientController.delete(client_to_be_changed);
    }
    public void updateClient() {
        Client client_to_be_changed = searchClientByName();
        Client client1 = client_to_be_changed;
        System.out.println("----------------Update----------------\n" +
                "- Name\n" +
                "- Phone Number\n" +
                "- Email\n" +
                "- Address\n" +
                "- Exit\n");
        String option = returnInput();
        switch (option){
            case "Name": {
                System.out.println("New name: ");
                String name = returnInput();
                client1.setName(name);
                clientController.update(client_to_be_changed, client1);
                break;
            }
            case "Phone Number":{
                System.out.println("New phone number: ");
                String number = returnInput();
                client1.setPhone_number(number);
                clientController.update(client_to_be_changed, client1);
                break;
            }
            case "Email": {
                System.out.println("New email: ");
                String email = returnInput();
                client1.setEmail(email);
                clientController.update(client_to_be_changed, client1);
                break;
            }
            case "Address": {
                System.out.println("Under Construction");
                break;
            }
            case "Exit": {
                break;
            }
        }

    }
    public void updateBookingInfo() {
        System.out.println("Under Construction");
    }
    public void searchBookingByClientName() {
        System.out.println("Under Construction");
    }

    @Override
    public String returnInput(){
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    @Override
    public void login() {
        System.out.println("----------------Login------------------\n" +
                "Password: ");
        String password = returnInput();
        if (!admin.login("admin", password)){
            return;
        }
        run();
    }
}
