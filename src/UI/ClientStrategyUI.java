package UI;

import Controller.People.ClientController;
import Factory.ClientFactory;

import java.util.Scanner;

public class ClientStrategyUI implements ReturnInput, UIStrategy {
    private String clientContextActionMenu;

    private ClientFactory clientFactory;

    private ClientController clientController;

    public ClientStrategyUI(ClientController clientController){
        this.clientController = clientController;
        this.clientFactory = new ClientFactory();
        this.clientContextActionMenu = "----------------User Menu------------------\n" +
                "1. Book a stay\n" +
                "2. Place restaurant order\n";
    }
    public void run(){

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

    @Override
    public void login(){
        System.out.println("----------------Login------------------\n" +
                "Username: ");
        String username = returnInput();

    }
}
