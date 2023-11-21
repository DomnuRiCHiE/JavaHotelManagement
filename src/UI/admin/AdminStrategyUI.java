package UI.admin;

import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.People.ClientController;
import Domain.People.Admin;
import Domain.People.Client;
import UI.ReturnInput;
import UI.UIStrategy;

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
                "11. Go back";
        this.clientController = clientController;
        this.bookingController = bookingController;
        this.hotelController = hotelController;
        this.roomController = roomController;
    }

    public void run() {
        while (true) {
            System.out.println(this.adminContextMenuActions);
            String option = returnInput();
            if (Objects.equals(option,"11")){
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
                default: break;
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
