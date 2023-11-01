package Repository.Restaurant;

import Domain.Restaurant.Beverage;
import Domain.Restaurant.Food;
import Domain.Restaurant.FoodType;
import Repository.IRepository;

import java.util.ArrayList;

public class MenuRepository<Item> implements IRepository<Item> {
    private final ArrayList<Item> menuItems;

    private MenuRepository() {
        menuItems = new ArrayList<>();
        Food menuItem1 = new Food("Tomato Soup", 10, "Refreshing bowl of soup", 300, FoodType.SOUP);
        Food menuItem2 = new Food("Mushroom Soup", 12, "Refreshing bowl of soup", 300, FoodType.SOUP);
        Food menuItem3 = new Food("Wagyu Steak", 50, "Pan fried chunk of meat", 200, FoodType.MEAT);
        Beverage menuItem4 = new Beverage("Water", 8, "H2O", 500);
        Beverage menuItem5 = new Beverage("Pepsi", 11, "Refreshing soda", 330);
        Beverage menuItem6 = new Beverage("Fanta", 11, "Refreshing soda", 330);


        menuItems.add((Item) menuItem1);
        menuItems.add((Item) menuItem2);
        menuItems.add((Item) menuItem3);
        menuItems.add((Item) menuItem4);
        menuItems.add((Item) menuItem5);
        menuItems.add((Item) menuItem6);
    }

    @Override
    public void add(Item object) {
        if(!menuItems.contains(object)) {
            menuItems.add(object);
        }
    }

    @Override
    public void update(Item object1, Item object2) {
        if(menuItems.contains(object1)) {
            menuItems.remove(object1);
            menuItems.add(object2);
        }
    }

    @Override
    public void delete(Item object) {
        if(menuItems.contains(object)) {
            menuItems.remove(object);
        }
    }

    @Override
    public ArrayList<Item> getAll() {
        return new ArrayList<>(menuItems);
    }
}
