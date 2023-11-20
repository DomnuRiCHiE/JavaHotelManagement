package Controller.Restaurant;

import Controller.Interfaces.IRestaurantOrderController;
import Controller.MainController;
import Domain.Restaurant.RestaurantOrder;
import Repository.Interfaces.IRestaurantOrderRepository;
import Repository.Restaurant.RestaurantOrderRepository;
import java.util.ArrayList;

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

    public void add(RestaurantOrder object) {
        super.add(object);
    }

    public void delete(RestaurantOrder object) {
        super.delete(object);
    }

    public void update(RestaurantOrder object1, RestaurantOrder object2) {
        super.update(object1, object2);
    }

    public ArrayList<RestaurantOrder> getAll() {
        return super.getAll();
    }
}
