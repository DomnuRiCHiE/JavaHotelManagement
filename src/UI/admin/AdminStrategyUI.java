package UI.admin;

import Controller.People.ClientController;
import Domain.People.Admin;
import UI.ReturnInput;
import UI.UIStrategy;

import java.util.Scanner;

public class AdminStrategyUI implements ReturnInput, UIStrategy {
    private String adminContextMenuActions;

    private ClientController clientController;

    private Admin admin;

    public AdminStrategyUI() {
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
        this.clientController = ClientController.getInstance();
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
    public void getClientsInfoList() {}
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
    public void updateClient() {}
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
