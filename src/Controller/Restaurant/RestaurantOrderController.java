package Controller.Restaurant;

import Controller.Interfaces.IRestaurantOrderController;
import Controller.MainController;
import Domain.Restaurant.RestaurantOrder;
import Repository.Interfaces.IRestaurantOrderRepository;
import Repository.Restaurant.RestaurantOrderRepository;

public class RestaurantOrderController extends MainController<RestaurantOrder> implements IRestaurantOrderController {
    private static RestaurantOrderController instance;
    private final IRestaurantOrderRepository restaurantOrderRepositoryInterface;

    private RestaurantOrderController(RestaurantOrderRepository restaurantOrderRepository) {
        super(restaurantOrderRepository);
        restaurantOrderRepositoryInterface = restaurantOrderRepository;
    }

    public static RestaurantOrderController getInstance() {
        if(instance == null) {
            instance = new RestaurantOrderController(RestaurantOrderRepository.getInstance());
        }
        return instance;
    }
}
