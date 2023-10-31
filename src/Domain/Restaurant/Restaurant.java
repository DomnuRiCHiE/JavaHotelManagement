package Domain.Restaurant;

import java.util.ArrayList;

public class Restaurant {
    private Menu menu;
    private ArrayList<RestaurantOrder> orders = new ArrayList<>();

    public Restaurant(Menu menu, ArrayList<RestaurantOrder> orders) {
        this.menu = menu;
        this.orders = orders;
    }
}
