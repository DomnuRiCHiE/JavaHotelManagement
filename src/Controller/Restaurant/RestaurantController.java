package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.Restaurant;
import Repository.Restaurant.RestaurantRepository;

public class RestaurantController extends MainController<Restaurant> {
    public RestaurantController(RestaurantRepository restaurantRepository) {
        super(restaurantRepository);
    }
}
