package UI;

//import Controller.Controller;

import UI.admin.AdminUI;

import java.io.Console;
import java.util.Scanner;

public class UI implements ReturnInput{
    private String startUpMenu;
    private String loginMenu;

//    private Controller controller;

//    public void setController(Controller controller) {
//        this.controller = controller;
//    }

    public UI() {
        this.startUpMenu = "----------------Welcome------------------\n" +
                "-To login as an user, please type 'login' \n" +
                "-To have admin controls, type 'admin' \n" +
                "-To quit the app, type 'quit' \n";
        this.loginMenu = "----------------Login------------------\n";
    }

    public void run() {
        System.out.println(startUpMenu);
        String option = returnInput();
        selectWelcomeScreenOptions(option);
    }

    public void selectWelcomeScreenOptions(String option) {
        switch (option) {
            case "login": {
                loginTypeUsernameScreen();
                break;
            }
            case "admin":{
                loginTypePasswordScreenAdmin();
                break;
            }
            case "quit": {
                System.out.println("Bye bye!");
                break;
            }
        }
    }

    public String returnInput(){
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }

    public void loginTypeUsernameScreen() {
        System.out.println(this.loginMenu);
        System.out.println("Enter username");
        String username = returnInput();
//        check if username is correct
        loginTypePasswordScreen();
    }

    public void loginTypePasswordScreen() {
        System.out.println(this.loginMenu);
        System.out.println("Enter password:");
        String password = returnInput();
//        check if password is correct
        ClientUI clientUI = new ClientUI();
    }
    public void loginTypePasswordScreenAdmin() {
        System.out.println(this.loginMenu);
        System.out.println("Enter password:");
        String password = returnInput();
//        check if password is correct
        AdminUI adminUI = new AdminUI();
        adminUI.run();
    }
}
