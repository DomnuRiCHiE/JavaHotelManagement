package Controller.Restaurant;

import Controller.IController;
import Domain.Restaurant.Restaurant;
import Repository.Restaurant.RestaurantRepository;

import java.util.ArrayList;

public class RestaurantController implements IController<Restaurant> {
    private final RestaurantRepository restaurantRepository;
    private static RestaurantController instance;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public static RestaurantController getInstance(RestaurantRepository restaurantRepository) {
        if(instance == null) {
            instance = new RestaurantController(restaurantRepository);
        }
        return instance;
    }

    @Override
    public void add(Restaurant object) {
        restaurantRepository.add(object);
    }

    @Override
    public void update(Restaurant object1, Restaurant object2) {
        restaurantRepository.update(object1, object2);
    }

    @Override
    public void delete(Restaurant object) {
        restaurantRepository.delete(object);
    }

    @Override
    public ArrayList<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }
}
