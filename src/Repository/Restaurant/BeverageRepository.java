package Repository.Restaurant;

import Domain.Restaurant.Beverage;
import Repository.IRepository;

import java.util.ArrayList;

public class BeverageRepository implements IRepository<Beverage> {
    private final ArrayList<Beverage> beverages;
    private static BeverageRepository instance;

    private BeverageRepository() {
        beverages = new ArrayList<>();
        Beverage beverage1 = new Beverage("Water", 8, "H2O", 500);
        Beverage beverage2 = new Beverage("Pepsi", 11, "Refreshing soda", 330);
        Beverage beverage3 = new Beverage("Fanta", 11, "Refreshing soda", 330);

        beverages.add(beverage1);
        beverages.add(beverage2);
        beverages.add(beverage3);
    }

    public static BeverageRepository getInstance() {
        if(instance == null) {
            instance = new BeverageRepository();
        }
        return instance;
    }


    @Override
    public void add(Beverage object) {
        if(!beverages.contains(object)) {
            beverages.add(object);
        }
    }

    @Override
    public void update(Beverage object1, Beverage object2) {
        if(beverages.contains(object1)) {
            beverages.remove(object1);
            beverages.add(object2);
        }
    }

    @Override
    public void delete(Beverage object) {
        if(beverages.contains(object)) {
            beverages.remove(object);
        }
    }

    @Override
    public ArrayList<Beverage> getAll() {
        return new ArrayList<>(beverages);
    }
}
