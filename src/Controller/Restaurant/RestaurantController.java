package Controller.Restaurant;

import Controller.Interfaces.IRestaurantController;
import Controller.MainController;
import Domain.Restaurant.Restaurant;
import Repository.Restaurant.RestaurantRepository;

public class RestaurantController extends MainController<Restaurant> implements IRestaurantController {
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
