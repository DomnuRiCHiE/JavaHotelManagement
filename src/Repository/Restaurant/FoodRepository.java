package Repository.Restaurant;

import Domain.Restaurant.Food;
import Domain.Restaurant.FoodType;
import Repository.IRepository;
import java.util.ArrayList;

public class FoodRepository implements IRepository<Food> {
    private final ArrayList<Food> foods;
    private static FoodRepository instance;

    private FoodRepository() {
        foods = new ArrayList<>();
        Food food1 = new Food("Tomato Soup", 10, "Refreshing bowl of soup", 300, FoodType.SOUP);
        Food food2 = new Food("Mushroom Soup", 12, "Refreshing bowl of soup", 300, FoodType.SOUP);
        Food food3 = new Food("Wagyu Steak", 50, "Pan fried chunk of meat", 200, FoodType.MEAT);

        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
    }

    public static FoodRepository getInstance() {
        if(instance == null) {
            instance = new FoodRepository();
        }
        return instance;
    }


    @Override
    public void add(Food object) {
        if(!foods.contains(object)) {
            foods.add(object);
        }
    }

    @Override
    public void update(Food object) {
        if(foods.contains(object)) {
            foods.remove(object);
            foods.add(object);
        }
    }

    @Override
    public void delete(Food object) {
        if(foods.contains(object)) {
            foods.remove(object);
        }
    }

    @Override
    public ArrayList<Food> getAll() {
        return new ArrayList<>(foods);
    }
}
