//package UI;
//
//import Controller.Controller;
//
//import javax.print.DocFlavor;
//import java.io.InputStream;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class UI {
//
//    private String startUpMenu;
//    private String adminContextMenu;
//
//    private Controller controller;
//
//    public void setController(Controller controller) {
//        this.controller = controller;
//    }
//
//    public UI() {
//        this.startUpMenu = "----------------StartUp------------------" +
//                "\n\n Press enter to log in";
//        this.adminContextMenu = "----------------Manage------------------" +
//                "\n1. Restaurant" +
//                "\n2. Bookings" +
//                "\n3. Rooms" +
//                "\n4. Clients" +
//                "\n\n Type the number of your desired option to manage it";
//    }
//
//    public void run() throws InterruptedException {
//        System.out.println(startUpMenu);
//        Scanner loginOption = new Scanner(System.in);
//        String option = loginOption.nextLine();
//        System.out.println("Logging in...");
//        System.out.println("Welcome!!");
//        login();
//    }
//
//    public void login() {
//        System.out.println(adminContextMenu);
//        Scanner contextMenuOption = new Scanner(System.in);
//        int option = contextMenuOption.nextInt();
//        switch (option){
//            case 1:{
//                manageRestaurant();
//                break;
//            }
//            case 2:{
//                manageBookings();
//                break;
//            }
//            case 3:{
//                manageRooms();
//                break;
//            }
//            case 4:{
//                manageClients();
//                break;
//            }
//
//        }
//    }
//
//    public void manageRestaurant(){
//
//    }
//
//    public void manageBookings(){
//
//    }
//    public void manageRooms(){
//
//    }
//    public void manageClients(){
//
//    }
//}
