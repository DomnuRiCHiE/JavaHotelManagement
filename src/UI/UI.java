package UI;


import Controller.Hotel.BookingController;
import Controller.Hotel.HotelController;
import Controller.Hotel.RoomController;
import Controller.People.ClientController;
import Domain.Hotel.Hotel;
import UI.admin.AdminStrategyUI;

import java.util.Scanner;

public class UI implements ReturnInput {
    private String startUpMenu;
    private String loginMenu;

    private final BookingController bookingController;
    private final HotelController hotelController;
    private final RoomController roomController;
    private final ClientController clientController;

    private UIStrategy uiStrategy;

    public void setUiStrategy(UIStrategy uiStrategy) {
        this.uiStrategy = uiStrategy;
    }

    public UI(BookingController bookingController, HotelController hotelController, RoomController roomController, ClientController clientController) {
        this.startUpMenu = "----------------Welcome------------------\n" +
                "-To login as an user, please type 'login' \n" +
                "-To have admin controls, type 'admin' \n" +
                "-To quit the app, type 'quit' \n";
        this.loginMenu = "----------------Login------------------\n";
        this.bookingController = bookingController;
        this.hotelController = hotelController;
        this.roomController = roomController;
        this.clientController = clientController;
    }

    public void run() {
        System.out.println(startUpMenu);
        String option = returnInput();
        selectWelcomeScreenOptions(option);
    }

    public void selectWelcomeScreenOptions(String option) {
        switch (option) {
            case "login": {
                setUiStrategy(new ClientStrategyUI(clientController));
                uiStrategy.login();
                break;
            }
            case "admin": {
                setUiStrategy(new AdminStrategyUI(bookingController,hotelController,roomController,clientController));
                uiStrategy.login();
                break;
            }
            case "quit": {
                System.out.println("Bye bye!");
                break;
            }
            default: break;
        }
    }

    public String returnInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }
}
