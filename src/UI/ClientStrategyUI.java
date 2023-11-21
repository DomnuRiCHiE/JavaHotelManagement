package UI;

import Controller.People.ClientController;
import Domain.People.Client;
import Factory.ClientFactory;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ClientStrategyUI implements ReturnInput, UIStrategy {
    private String clientContextActionMenu;

    private ClientFactory clientFactory;

    private ClientController clientController;

    public ClientStrategyUI(ClientController clientController) {
        this.clientController = clientController;
        this.clientFactory = new ClientFactory();
        this.clientContextActionMenu = "----------------User Menu------------------\n" +
                "1. Book a stay\n" +
                "2. Place restaurant order\n";
    }

    public void run(){
        System.out.println(clientContextActionMenu);
        showClientOptions();
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

    @Override
    public void login(){
        System.out.println("----------------Login------------------\n");
        Client client = searchClientByName();
        System.out.println("Password: ");
        String password = returnInput();
        if (!client.login(client.getName(),password)){
            return;
        }
        run();
    }
}
