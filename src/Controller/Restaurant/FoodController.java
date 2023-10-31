package Controller.Restaurant;

import Domain.Restaurant.Food;
import Repository.Restaurant.FoodRepository;
import Controller.IController;
import java.util.ArrayList;

public class FoodController implements IController<Food> {
    private final FoodRepository foodRepository;
    private static FoodController instance;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public static FoodController getInstance(FoodRepository foodRepository) {
        if(instance == null) {
            instance = new FoodController(foodRepository);
        }
        return instance;
    }

    @Override
    public void add(Food object) {
        foodRepository.add(object);
    }

    @Override
    public void update(Food object) {
        foodRepository.update(object);
    }

    @Override
    public void delete(Food object) {
        foodRepository.delete(object);
    }

    @Override
    public ArrayList<Food> getAll() {
        return foodRepository.getAll();
    }
}
