package Controller.Restaurant;

import Controller.Interfaces.IRestaurantController;
import Controller.MainController;
import Domain.Restaurant.Restaurant;
import Repository.Interfaces.IRestaurantRepository;
import Repository.Restaurant.RestaurantRepository;

public class RestaurantController extends MainController<Restaurant> implements IRestaurantController {
    private static RestaurantController instance;
    private final IRestaurantRepository restaurantRepositoryInterface;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        super(restaurantRepository);
        restaurantRepositoryInterface = restaurantRepository;
    }

    public static RestaurantController getInstance() {
        if(instance == null) {
            instance = new RestaurantController(RestaurantRepository.getInstance());
        }
        return instance;
    }
}
