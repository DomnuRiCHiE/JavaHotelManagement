package Repository.Restaurant;

import Domain.Restaurant.SpicyFood;
import Repository.MainRepository;

public class SpicyFoodRepository extends MainRepository<SpicyFood> {
    private static SpicyFoodRepository instance;

    private SpicyFoodRepository() {
        super();
    }

    public static SpicyFoodRepository getInstance() {
        if(instance == null) {
            instance = new SpicyFoodRepository();
        }
        return instance;
    }
}
