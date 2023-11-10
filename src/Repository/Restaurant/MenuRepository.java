package Repository.Restaurant;

import Domain.Restaurant.Menu;
import Repository.MainRepository;

public class MenuRepository<Item> extends MainRepository<Menu<Item>> {
    private static MenuRepository<?> instance;

    private MenuRepository() {
        super();
    }

    @SuppressWarnings("unchecked")
    public static <T> MenuRepository<T> getInstance() {
        if (instance == null) {
            instance = new MenuRepository<>();
        }
        return (MenuRepository<T>) instance;
    }
}

//        Food menuItem1 = new Food("Tomato Soup", 10, "Refreshing bowl of soup", 300, FoodType.SOUP);
//        Food menuItem2 = new Food("Mushroom Soup", 12, "Refreshing bowl of soup", 300, FoodType.SOUP);
//        Food menuItem3 = new Food("Wagyu Steak", 50, "Pan fried chunk of meat", 200, FoodType.MEAT);
//        Beverage menuItem4 = new Beverage("Water", 8, "H2O", 500);
//        Beverage menuItem5 = new Beverage("Pepsi", 11, "Refreshing soda", 330);
//        Beverage menuItem6 = new Beverage("Fanta", 11, "Refreshing soda", 330);
