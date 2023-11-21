package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.SpicyFood;
import Repository.Restaurant.SpicyFoodRepository;

public class SpicyFoodController extends MainController<SpicyFood> {
    public SpicyFoodController(SpicyFoodRepository spicyFoodRepository) {
        super(spicyFoodRepository);
    }
}
