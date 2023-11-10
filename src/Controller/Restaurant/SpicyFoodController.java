package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.SpicyFood;
import Repository.Restaurant.SpicyFoodRepository;

public class SpicyFoodController extends MainController<SpicyFood> {
    private static SpicyFoodController instance;

    public SpicyFoodController() {
        super(SpicyFoodRepository.getInstance());
    }

    public static SpicyFoodController getInstance() {
        if(instance == null) {
            instance = new SpicyFoodController();
        }
        return instance;
    }
}
