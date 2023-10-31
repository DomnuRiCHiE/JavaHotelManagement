package UI;

import Controller.Controller;

import javax.print.DocFlavor;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    private String startUpMenu;
    private String adminContextMenu;

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public UI() {
        this.startUpMenu = "----------------StartUp------------------" +
                "\n\n Press enter to log in";
        this.adminContextMenu = "----------------Manage------------------" +
                "\n1. Restaurant" +
                "\n2. Bookings" +
                "\n3. Rooms" +
                "\n4. ";
    }

    public void run() throws InterruptedException {
        System.out.println(startUpMenu);
        Scanner loginOption = new Scanner(System.in);
        String option = loginOption.nextLine();
        System.out.println("Logging in...");
        login();
    }

    public void login() {

    }
}
