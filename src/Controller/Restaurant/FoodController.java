package Controller.Restaurant;

import Controller.Interfaces.IFoodController;
import Controller.MainController;
import Domain.Restaurant.Food;
import Repository.Interfaces.IFoodRepository;
import Repository.Restaurant.FoodRepository;
import java.util.ArrayList;

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

    public void add(Food object) {
        super.add(object);
    }

    public void delete(Food object) {
        super.delete(object);
    }

    public void update(Food object1, Food object2) {
        super.update(object1, object2);
    }

    public ArrayList<Food> getAll() {
        return super.getAll();
    }
}
