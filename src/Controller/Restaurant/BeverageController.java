package Controller.Restaurant;

import Controller.Interfaces.IBeverageController;
import Controller.MainController;
import Domain.Restaurant.Beverage;
import Repository.Interfaces.IBeverageRepository;
import Repository.Restaurant.BeverageRepository;
import java.util.ArrayList;

public class BeverageController extends MainController<Beverage> implements IBeverageController {
    private static BeverageController instance;
    private final IBeverageRepository beverageRepositoryInterface;

    public BeverageController(BeverageRepository beverageRepository) {
        super(beverageRepository);
        beverageRepositoryInterface = beverageRepository;
    }

    public static BeverageController getInstance() {
        if(instance == null) {
            instance = new BeverageController(BeverageRepository.getInstance());
        }
        return instance;
    }

    public void add(Beverage object) {
        super.add(object);
    }

    public void delete(Beverage object) {
        super.delete(object);
    }

    public void update(Beverage object1, Beverage object2) {
        super.update(object1, object2);
    }

    public ArrayList<Beverage> getAll() {
        return super.getAll();
    }
}
