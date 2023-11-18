package Controller.Restaurant;

import Controller.Interfaces.IBeverageController;
import Controller.MainController;
import Domain.Restaurant.Beverage;
import Repository.Interfaces.IBeverageRepository;
import Repository.Restaurant.BeverageRepository;

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
}
