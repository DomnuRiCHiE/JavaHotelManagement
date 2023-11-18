package Controller.Restaurant;

import Controller.Interfaces.IFoodController;
import Controller.MainController;
import Domain.Restaurant.Food;
import Repository.Interfaces.IFoodRepository;
import Repository.Restaurant.FoodRepository;

public class FoodController extends MainController<Food> implements IFoodController {
    private static FoodController instance;
    private final IFoodRepository foodRepositoryInterface;

    public FoodController(FoodRepository foodRepository) {
        super(foodRepository);
        foodRepositoryInterface = foodRepository;
    }

    public static FoodController getInstance() {
        if(instance == null) {
            instance = new FoodController(FoodRepository.getInstance());
        }
        return instance;
    }
}
