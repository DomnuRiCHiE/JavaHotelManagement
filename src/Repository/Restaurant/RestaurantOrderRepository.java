package Repository.Restaurant;

import Domain.Restaurant.RestaurantOrder;
import Repository.MainRepository;

public class RestaurantOrderRepository extends MainRepository<RestaurantOrder> {
    private static RestaurantOrderRepository instance;

    private RestaurantOrderRepository() {
        super();
    }

    public static RestaurantOrderRepository getInstance() {
        if(instance == null) {
            instance = new RestaurantOrderRepository();
        }
        return instance;
    }
}
