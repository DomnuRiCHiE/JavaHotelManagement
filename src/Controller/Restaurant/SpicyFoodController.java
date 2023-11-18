package Controller.Restaurant;

import Controller.Interfaces.ISpicyFoodController;
import Controller.MainController;
import Domain.Restaurant.SpicyFood;
import Repository.Interfaces.ISpicyFoodRepository;
import Repository.Restaurant.SpicyFoodRepository;

public class SpicyFoodController extends MainController<SpicyFood> implements ISpicyFoodController {
    private static SpicyFoodController instance;
    private final ISpicyFoodRepository spicyFoodRepositoryInterface;

    public SpicyFoodController(SpicyFoodRepository spicyFoodRepository) {
        super(spicyFoodRepository);
        spicyFoodRepositoryInterface = spicyFoodRepository;
    }

    public static SpicyFoodController getInstance() {
        if(instance == null) {
            instance = new SpicyFoodController(SpicyFoodRepository.getInstance());
        }
        return instance;
    }
}
