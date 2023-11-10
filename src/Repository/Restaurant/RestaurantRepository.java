package Repository.Restaurant;

import Domain.Restaurant.Restaurant;
import Repository.MainRepository;


public class RestaurantRepository extends MainRepository<Restaurant> {
    private static RestaurantRepository instance;

    private RestaurantRepository() {
        super();
    }

    public static RestaurantRepository getInstance() {
        if(instance == null) {
            instance = new RestaurantRepository();
        }
        return instance;
    }
}
