package UI;


import UI.admin.AdminUI;

import java.io.Console;
import java.util.Scanner;

public class UI implements ReturnInput{
    private String startUpMenu;
    private String loginMenu;

    private UIStrategy uiStrategy;

    public void setUiStrategy(UIStrategy uiStrategy) {
        this.uiStrategy = uiStrategy;
    }

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
                setUiStrategy(new ClientUI());
                uiStrategy.login();
                break;
            }
            case "admin":{
                setUiStrategy(new AdminUI());
                uiStrategy.login();
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
}
