package UI;


import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.People.ClientController;
import Repository.Hotel.BookingRepository;
import Repository.Hotel.HotelRepository;
import Repository.Hotel.RoomRepository;
import Repository.People.ClientRepository;
import UI.admin.AdminStrategyUI;

import java.util.Objects;
import java.util.Scanner;

public class UI implements ReturnInput {
    private String startUpMenu;
    private String loginMenu;

    private UIStrategy uiStrategy;

    private ClientController clientController;
    private BookingController bookingController;
    private HotelController hotelController;
    private RoomController roomController;

    public void setUiStrategy(UIStrategy uiStrategy) {
        this.uiStrategy = uiStrategy;
    }

    public UI(ClientController clientController, BookingController bookingController, HotelController hotelController, RoomController roomController) {
        this.startUpMenu = "----------------Welcome------------------\n" +
                "-To login as an user, please type 'login' \n" +
                "-To have admin controls, type 'admin' \n" +
                "-To quit the app, type 'quit' \n";
        this.loginMenu = "----------------Login------------------\n";
        this.clientController = clientController;
        this.bookingController = bookingController;
        this.hotelController = hotelController;
        this.roomController = roomController;
    }

    public void run() {
        while (true) {
            System.out.println(startUpMenu);
            String option = returnInput();

            selectWelcomeScreenOptions(option);
            if (Objects.equals(option,"quit")){
                break;
            }
            if (uiStrategy != null){
                uiStrategy.login();
            }
        }
    }

    public void selectWelcomeScreenOptions(String option) {

        switch (option) {
            case "login": {
                setUiStrategy(new ClientStrategyUI(clientController));
                break;
            }
            case "admin": {
                setUiStrategy(new AdminStrategyUI(bookingController, hotelController, roomController, clientController));
                break;
            }
            case "quit": {
                System.out.println("Bye bye!");
                break;
            }
            default:
                break;
        }

    }

    public String returnInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }
}
