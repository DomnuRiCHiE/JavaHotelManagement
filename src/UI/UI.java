package UI;

import javax.print.DocFlavor;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    private String startUpMenu;
    private String userContextMenu;
    private String adminContextMenu;

    public UI() {
        this.startUpMenu = "----------------StartUp------------------" +
                "\n1.Login as User" +
                "\n2.Login as Admin" +
                "\n\n To login, please type user/admin";
    }

    public void run() throws InterruptedException {
        System.out.println(startUpMenu);
        Scanner loginOption = new Scanner(System.in);
        String option = loginOption.nextLine();
        switch (option) {
            case "user": {
                System.out.println("Logging in...");
                loginAsUser();
                break;
            }
            case "admin": {
                System.out.println("Logging in...");
                loginAsAdmin();
                break;
            }
            default: {
                System.out.println("Wrong input! Try again.");
                Thread.sleep(5);
            }
        }
    }

    public void loginAsUser() {

    }

    public void loginAsAdmin() {

    }
}
