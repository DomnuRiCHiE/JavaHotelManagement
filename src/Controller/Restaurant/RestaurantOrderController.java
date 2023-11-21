package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.RestaurantOrder;
import Repository.Restaurant.RestaurantOrderRepository;
import java.util.ArrayList;

public class RestaurantOrderController extends MainController<RestaurantOrder> {
    public RestaurantOrderController(RestaurantOrderRepository restaurantOrderRepository) {
        super(restaurantOrderRepository);
    }
}
