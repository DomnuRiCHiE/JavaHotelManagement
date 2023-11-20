package Controller.Restaurant;

import Controller.Interfaces.IRestaurantController;
import Controller.MainController;
import Domain.Restaurant.Restaurant;
import Repository.Interfaces.IRestaurantRepository;
import Repository.Restaurant.RestaurantRepository;
import java.util.ArrayList;

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

    public void add(Restaurant object) {
        super.add(object);
    }

    public void delete(Restaurant object) {
        super.delete(object);
    }

    public void update(Restaurant object1, Restaurant object2) {
        super.update(object1, object2);
    }

    public ArrayList<Restaurant> getAll() {
        return super.getAll();
    }
}
