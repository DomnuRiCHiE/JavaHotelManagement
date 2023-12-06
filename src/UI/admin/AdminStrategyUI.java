package UI.admin;

import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.Observer.Observers.ObserverRoomOccupancy;
import Controller.Observer.Subjects.SubjectRoomOccupancy;
import Controller.People.ClientController;
import Controller.Restaurant.AlcoholicBeveragesController;
import DAO.AlcoholicBeverageDAO;
import Domain.Hotel.Room;
import Domain.Hotel.RoomCategories;
import Domain.People.Admin;
import Domain.People.Client;
import Domain.Restaurant.AlcoholicBeverages;
import Repository.Restaurant.AlcoholicBeverageRepository;
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

    private AlcoholicBeveragesController alcoholicBeveragesController;

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
                "8. list all alcoholic beverages\n" +
                "9. delete alcoholic beverage\n" +
                "10. add alcoholic beverage\n" +
                "11. observer pattern\n" +
                "12. modify alcoholic beverage\n" +
                "0. Go back";
        this.clientController = clientController;
        this.bookingController = bookingController;
        this.hotelController = hotelController;
        this.roomController = roomController;
        this.alcoholicBeveragesController = new AlcoholicBeveragesController(AlcoholicBeverageRepository.getInstance(),AlcoholicBeverageDAO.getInstance());
    }

    public void run() {
        while (true) {
            System.out.println(this.adminContextMenuActions);
            String option = returnInput();
            if(Objects.equals(option, "0")){
                break;
            }
            switch (option) {
                case "1":
                    getClientsInfoList();
                    break;
                case "2":
                    updateClient();
                    break;
                case "3":
                    searchBookingByClientName();
                    break;
                case "4":
                    assignRestaurantToHotel();
                    break;
                case "5":
                    manageRestaurant();
                    break;
                case "6":
                    updateBookingInfo();
                    break;
                case "7":
                    deleteClientFromHotel();
                    break;
                case "8":
                    listALlAlcoholicBeverages();
                    break;
                case "9":
                    deleteAlcoholicBeverage();
                    break;
                case "10":
                    addAlcoholicBeverage();
                    break;
                case "11":
                    observerPattern();
                    break;
                case "12":
                    modifyAlcoholicBeverage();
                    break;
                case "0":
                    break;
            }
        }
    }

    public void observerPattern() {
        SubjectRoomOccupancy subjectRoomOccupancy = new SubjectRoomOccupancy();
        ObserverRoomOccupancy observerRoomOccupancy = new ObserverRoomOccupancy();

        subjectRoomOccupancy.addObserver(observerRoomOccupancy);

        Scanner scanner = new Scanner(System.in);
        while (true) {
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

    public void modifyAlcoholicBeverage() {
        System.out.println("Name:");
        String name = returnInput();
        ArrayList<AlcoholicBeverages> objects = alcoholicBeveragesController.getAll();
        System.out.println("New price:");

        Integer price = Integer.parseInt(returnInput());
        System.out.println("New description:");
        String description = returnInput();
        System.out.println("New volume:");
        Integer volume = Integer.parseInt(returnInput());
        System.out.println("New percentage:");
        Integer percentage = Integer.parseInt(returnInput());
        for (AlcoholicBeverages a : objects) {
            if (Objects.equals(a.getName(), name)) {
                alcoholicBeveragesController.update(a, new AlcoholicBeverages(a.getName(), price, description, volume, percentage));
                System.out.println("Product has been changed");
                return;
            }
        }
        System.out.println("Product not found...");
    }

    public void assignRestaurantToHotel() {
        System.out.println("Under Construction");
    }

    public void manageRestaurant() {
        System.out.println("Under Construction");
    }// uses ManageRestaurantUI

    public void deleteAlcoholicBeverage() {
        System.out.println("Name:");
        String name = returnInput();
        ArrayList<AlcoholicBeverages> objects = alcoholicBeveragesController.getAll();
        for (AlcoholicBeverages a: objects){
            if(Objects.equals(a.getName(), name)) {
                alcoholicBeveragesController.delete(a);
                System.out.println("Product deleted successfully!");
                return;
            }
        }
        System.out.println("Product not found...");
    }

    public void getClientsInfoList() {
        Client client = searchClientByName();
        System.out.println(clientController.getClientInfoList(client));
    }

    public Client searchClientByName() {
        System.out.println("Client name: ");
        String name = returnInput();
        ArrayList<Client> clients = clientController.getAll();
        Client client_to_be_changed = new Client();
        for (Client client : clients) {
            if (Objects.equals(client.getName(), name)) {
                client_to_be_changed = client;
                break;
            }
        }
        return client_to_be_changed;
    }

    public void listALlAlcoholicBeverages() {
        System.out.println("List of Alcoholic Beverages");
        ArrayList<AlcoholicBeverages> objects = alcoholicBeveragesController.getAll();
        for (AlcoholicBeverages a: objects){
            System.out.println(a.toString());
        }
    }

    public void addAlcoholicBeverage() {
        System.out.println("Name: ");
        String name = returnInput();
        ArrayList<AlcoholicBeverages> objects = alcoholicBeveragesController.getAll();
        for (AlcoholicBeverages a: objects){
            if(Objects.equals(a.getName(), name)){
                System.out.println("Name already used...");
                return;
            }
        }
        System.out.println("Price:");
        Integer price = Integer.parseInt(returnInput());
        System.out.println("Description:");
        String description = returnInput();
        System.out.println("Volume:");
        Integer volume = Integer.parseInt(returnInput());
        System.out.println("Percentage:");
        Integer percentage = Integer.parseInt(returnInput());
        alcoholicBeveragesController.add(new AlcoholicBeverages(name,price,description,volume,percentage));
        System.out.println("New object added!");

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
        switch (option) {
            case "Name": {
                System.out.println("New name: ");
                String name = returnInput();
                client1.setName(name);
                clientController.update(client_to_be_changed, client1);
                break;
            }
            case "Phone Number": {
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
    public String returnInput() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    @Override
    public void login() {
        System.out.println("----------------Login------------------\n" +
                "Password: ");
        String password = returnInput();
        if (!admin.login("admin", password)) {
            return;
        }
        run();
    }
}
