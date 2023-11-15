package UI.admin;

import Controller.People.ClientController;
import Domain.Hotel.RoomCategories;
import UI.ReturnInput;

import java.util.Scanner;

public class AdminUI implements ReturnInput {
    private String adminContextMenuActions;

    private ClientController clientController;

    public AdminUI() {
        this.adminContextMenuActions = "----------------Admin Menu------------------\n" +
                "1. getClientsInfoList\n" +
                "2. searchClientByName\n" +
                "3. modifyClientName\n" +
                "4. modifyClientPhoneNumber\n" +
                "5. modifyClientAddress\n" +
                "6. modifyClientEmail\n" +
                "7. searchBookingByClientName\n" +
                "8. assignRestaurantToHotel\n" +
                "9. manageRestaurant\n" +
                "10. modifyBookingInfo\n" +
                "11. deleteClientFromHotel\n" +
                "12. deleteRoomFromHotel\n" +
                "13. manageRoom\n" +
                "14. addRoomToHotel\n" +
                "15. Go back";
        this.clientController = ClientController.getInstance();
    }

    public void run() {
        System.out.println(this.adminContextMenuActions);
        String option = returnInput();
        switch (option){
            case "1": getClientsInfoList(); break;
            case "2": searchClientByName(); break;
            case "3": modifyClientName(); break;
            case "4": modifyClientPhoneNumber(); break;
            case "5": modifyClientAddress(); break;
            case "6": modifyClientEmail(); break;
            case "7": searchBookingByClientName(); break;
            case "8": assignRestaurantToHotel(); break;
            case "9": manageRestaurant(); break;
            case "10": modifyBookingInfo(); break;
            case "11": deleteClientFromHotel(); break;
            case "12": deleteRoomFromHotel(); break;
            case "13": manageRoom(); break;
            case "14": addRoomToHotel(); break;
            case "15": break;
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
    public void modifyClientName() {}
    public void modifyClientPhoneNumber() {}
    public void modifyClientAddress() {}
    public void modifyClientEmail() {}
    public void modifyBookingInfo() {}
    public void searchBookingByClientName() {}

    @Override
    public String returnInput(){
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
