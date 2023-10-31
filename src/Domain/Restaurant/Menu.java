package Domain.Restaurant;

import java.util.ArrayList;

public class Menu<Item> {
    private ArrayList<Item> menu;

    public Menu(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public ArrayList<Item> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Item> menu) {
        this.menu = menu;
    }
}
