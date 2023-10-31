package Controller.Restaurant;

import Controller.IController;
import Domain.Restaurant.Beverage;
import Repository.Restaurant.BeverageRepository;
import java.util.ArrayList;

public class BeverageController implements IController<Beverage> {
    private final BeverageRepository beverageRepository;
    private static BeverageController instance;

    public BeverageController(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public static BeverageController getInstance(BeverageRepository beverageRepository) {
        if(instance == null) {
            instance = new BeverageController(beverageRepository);
        }
        return instance;
    }

    @Override
    public void add(Beverage object) {
        beverageRepository.add(object);
    }

    @Override
    public void update(Beverage object) {
        beverageRepository.update(object);
    }

    @Override
    public void delete(Beverage object) {
        beverageRepository.delete(object);
    }

    @Override
    public ArrayList<Beverage> getAll() {
        return beverageRepository.getAll();
    }
}
