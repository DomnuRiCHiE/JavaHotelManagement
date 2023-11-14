package UI;

//import Controller.Controller;

import java.io.Console;
import java.util.Scanner;

public class UI implements UInterface {
    private String startUpMenu;
    private String loginMenu;

//    private Controller controller;

//    public void setController(Controller controller) {
//        this.controller = controller;
//    }

    public UI() {
        this.startUpMenu = "----------------Welcome------------------\n" +
                "-To login, please type 'login' \n" +
                "-To quit the app, type 'quit' \n";
        this.loginMenu = "----------------Login------------------\n";
    }

    public void run() {
        System.out.println(startUpMenu);
        Scanner loginOption = new Scanner(System.in);
        String option = loginOption.nextLine();
        selectWelcomeScreenOptions(option);
    }

    public void selectWelcomeScreenOptions(String option) {
        switch (option) {
            case "login": {
                loginTypeUsernameScreen();
                break;
            }
            case "quit": {
                System.out.println("Bye bye!");
                break;
            }
        }
    }

    public void loginTypeUsernameScreen() {
        System.out.println(this.loginMenu);
        System.out.println("Enter username");
        Scanner reader = new Scanner(System.in);
        String username = reader.nextLine();
        loginTypePasswordScreen();
    }

    @Override
    public void loginTypePasswordScreen() {
        Console cnsl = System.console();
        if (cnsl == null) {
            System.out.println("No console available");
            return;
        }

        char[] password = cnsl.readPassword("Enter password:");
    }

    public void manageRooms() {

    }

    public void manageClients() {

    }
}
