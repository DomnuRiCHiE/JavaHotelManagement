package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.Restaurant;
import Repository.Restaurant.RestaurantRepository;

public class RestaurantController extends MainController<Restaurant> {
    private static RestaurantController instance;

    public RestaurantController() {
        super(RestaurantRepository.getInstance());
    }

    public static RestaurantController getInstance() {
        if(instance == null) {
            instance = new RestaurantController();
        }
        return instance;
    }
}
