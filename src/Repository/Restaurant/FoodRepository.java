package Repository.Restaurant;

import Domain.Restaurant.Food;
import Repository.Interfaces.IFoodRepository;
import Repository.MainRepository;

public class FoodRepository extends MainRepository<Food> implements IFoodRepository {
    private static FoodRepository instance;

    private FoodRepository() {
        super();
    }

    public static FoodRepository getInstance() {
        if(instance == null) {
            instance = new FoodRepository();
        }
        return instance;
    }
}

//Food food1 = new Food("Tomato Soup", 10, "Refreshing bowl of soup", 300, FoodType.SOUP);
//Food food2 = new Food("Mushroom Soup", 12, "Refreshing bowl of soup", 300, FoodType.SOUP);
//Food food3 = new Food("Wagyu Steak", 50, "Pan fried chunk of meat", 200, FoodType.MEAT);
