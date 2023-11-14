package UI.admin;

import UI.ReturnInput;

import java.util.Scanner;

public class AdminUI implements ReturnInput {
    private String adminContextMenuActions;

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
                "14. addRoomToHotel\n";
    }

    public void run() {
        System.out.println(this.adminContextMenuActions);
        String option = returnInput();
        switch (option){
            case "1": getClientsInfoList(); break;
            case "2": searchClientByName(); break;
            case "3": modifyClientName(); break;
            case "4": modifyClientPhoneNumber(); break;
        }
    }

    public void assignRestaurantToHotel() {}

    public void manageRestaurant() {}// uses ManageRestaurantUI

    public void manageRoom(){}
    public void getClientsInfoList() {}
    public void searchClientByName() {}
    public void addRoomToHotel() {}
    public void deleteRoomFromHotel() {}
    public void deleteClientFromHotel() {}
    public void modifyClientName() {}
    public void modifyClientPhoneNumber() {}
    public void modifyClientAddress() {}
    public void modifyClientEmail() {}
    public void modifyBookingInfo() {}
    public void searchBookingByClientName() {}

    @Override
    public String returnInput(){
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }
}
