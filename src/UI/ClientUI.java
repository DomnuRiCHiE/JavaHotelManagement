package UI;

import java.util.Scanner;

public class ClientUI implements ReturnInput {
    private String clientContextActionMenu;
    public void run(){
        this.clientContextActionMenu = "----------------User Menu------------------\n" +
                "1. Book a stay\n" +
                "2. Place restaurant order\n";
    }
    public void showClientOptions(){
        String option = returnInput();
        switch (option){
            case "1": bookHotel(); break;
            case "2": placeRestaurantOrder(); break;
        }
    }
    public void bookHotel(){}
    public void placeRestaurantOrder(){}

    @Override
    public String returnInput() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
