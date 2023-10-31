package Domain.Restaurant;

import java.util.ArrayList;

public class Restaurant {
    private Menu<Item> menu;
    private ArrayList<RestaurantOrder> orders = new ArrayList<>();

    public Restaurant(Menu<Item> menu, ArrayList<RestaurantOrder> orders) {
        this.menu = menu;
        this.orders = orders;
    }

    public Menu<Item> getMenu() {
        return menu;
    }

    public void setMenu(Menu<Item> menu) {
        this.menu = menu;
    }

    public ArrayList<RestaurantOrder> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<RestaurantOrder> orders) {
        this.orders = orders;
    }
}
