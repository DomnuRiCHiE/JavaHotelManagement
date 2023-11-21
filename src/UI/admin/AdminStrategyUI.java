package UI.admin;

import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.People.ClientController;
import Domain.People.Admin;
import Domain.People.Client;
import UI.ReturnInput;
import UI.UIStrategy;

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
        login();
        this.adminContextMenuActions = "----------------Admin Menu------------------\n" +
                "1. getClientsInfoList\n" +
                "2. searchClientByName\n" +
                "3. modifyClient\n" +
                "4. searchBookingByClientName\n" +
                "5. assignRestaurantToHotel\n" +
                "6. manageRestaurant\n" +
                "7. modifyBookingInfo\n" +
                "8. deleteClientFromHotel\n" +
                "9. deleteRoomFromHotel\n" +
                "10. manageRoom\n" +
                "11. addRoomToHotel\n" +
                "12. Go back";
        this.clientController = clientController;
        this.bookingController = bookingController;
        this.hotelController = hotelController;
        this.roomController = roomController;
        run();
    }

    public void run() {
        System.out.println(this.adminContextMenuActions);
        String option = returnInput();
        switch (option){
            case "1": getClientsInfoList(); break;
            case "2": searchClientByName(); break;
            case "3": updateClient(); break;
            case "4": searchBookingByClientName(); break;
            case "5": assignRestaurantToHotel(); break;
            case "6": manageRestaurant(); break;
            case "7": updateBookingInfo(); break;
            case "8": deleteClientFromHotel(); break;
            case "9": deleteRoomFromHotel(); break;
            case "10": manageRoom(); break;
            case "11": addRoomToHotel(); break;
            case "12": break;
            default: option = returnInput();
        }
    }

    public void assignRestaurantToHotel() {}
    public void manageRestaurant() {}// uses ManageRestaurantUI
    public void manageRoom(){} // uses ManageRoomUI
    public void getClientsInfoList() {
        System.out.println("Name of the client: ");
        String client_name = returnInput();
//        clientController.getClientInfoList(clientController.searchByName(client_name));
    }
    public void searchClientByName() {
        System.out.println("Client name: ");
        String name = returnInput();
//      search in controller
    }
    public void addRoomToHotel() {
        System.out.println("Room number: ");
        int number =  Integer.parseInt(returnInput());
//      try catch  search room number in controller to see if it exists: update/fail?
        System.out.println("Room type: ");
        String type = returnInput();
//      try catch  RoomCategories room_type = changeToRoomCategory(type);
        System.out.println("Number of beds: ");
        int beds = Integer.parseInt(returnInput());
        System.out.println("Room price: ");
        int price = Integer.parseInt(returnInput());
//      try catch  controller.addRoom(number,type,beds,price)
    }
    public void deleteRoomFromHotel() {
        System.out.println("Room number: ");
//      try catch  controller.deleteRoom(Integer.parseInt(returnInput));
    }
    public void deleteClientFromHotel() {
        System.out.println("Client name: ");
        String name = returnInput();
//      try catch controller.deleteClient(name)
    }
    public void updateClient() {
        System.out.println("Name of the client: ");
        String client_name = returnInput();
//        Client client = clientController.ge(client_name);
//        Client client1 = client;
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
//                client1.setName(name);
                break;
            }
            case "Phone Number":{
                System.out.println("New phone number: ");
                String number = returnInput();
//                client1.setPhone_number(number);
                break;
            }
            case "Email": {
                System.out.println("New email: ");
                String email = returnInput();
//                client1.setEmail(email);
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
//        clientController.update(client, client1);
    }
    public void updateBookingInfo() {}
    public void searchBookingByClientName() {}

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
        while (true){
            if (admin.login("admin",password)){
                break;
            }
            System.out.println("Try again\n" +
                    "Password: ");
            password = returnInput();
        }
    }
}
