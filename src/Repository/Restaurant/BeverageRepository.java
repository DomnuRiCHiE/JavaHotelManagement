package Repository.Restaurant;

import Domain.Restaurant.Beverage;
import Repository.Interfaces.IBeverageRepository;
import Repository.MainRepository;

public class BeverageRepository extends MainRepository<Beverage> implements IBeverageRepository {
    private static BeverageRepository instance;

    private BeverageRepository() {
        super();
    }

    public static BeverageRepository getInstance() {
        if(instance == null) {
            instance = new BeverageRepository();
        }
        return instance;
    }
}

//Beverage beverage1 = new Beverage("Water", 8, "H2O", 500);
//Beverage beverage2 = new Beverage("Pepsi", 11, "Refreshing soda", 330);
//Beverage beverage3 = new Beverage("Fanta", 11, "Refreshing soda", 330);
