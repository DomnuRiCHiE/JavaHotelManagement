package Controller.Restaurant;

import Controller.Interfaces.ISpicyFoodController;
import Controller.MainController;
import Domain.Restaurant.SpicyFood;
import Repository.Interfaces.ISpicyFoodRepository;
import Repository.Restaurant.SpicyFoodRepository;
import java.util.ArrayList;

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

    public void add(SpicyFood object) {
        super.add(object);
    }

    public void delete(SpicyFood object) {
        super.delete(object);
    }

    public void update(SpicyFood object1, SpicyFood object2) {
        super.update(object1, object2);
    }

    public ArrayList<SpicyFood> getAll() {
        return super.getAll();
    }
}
