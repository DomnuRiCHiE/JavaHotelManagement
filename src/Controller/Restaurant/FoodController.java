package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.Food;
import Repository.Restaurant.FoodRepository;

public class FoodController extends MainController<Food> {
    public FoodController(FoodRepository foodRepository) {
        super(foodRepository);
    }
}
