import Domain.People.Admin;
import UI.UI;

public class Main {
    public static void main(String[] args) {
        Admin admin = Admin.getInstance();
        admin.setPassword("password");
        UI ui = new UI();
        ui.run();
    }
}
