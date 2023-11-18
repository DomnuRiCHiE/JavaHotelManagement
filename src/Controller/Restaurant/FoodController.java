package Controller.Restaurant;

import Controller.Interfaces.IFoodController;
import Controller.MainController;
import Domain.Restaurant.Food;
import Repository.Restaurant.FoodRepository;

public class FoodController extends MainController<Food> implements IFoodController {
    private static FoodController instance;

    public FoodController() {
        super(FoodRepository.getInstance());
    }

    public static FoodController getInstance() {
        if(instance == null) {
            instance = new FoodController();
        }
        return instance;
    }
}
