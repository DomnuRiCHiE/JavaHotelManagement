package Controller.Restaurant;

import Controller.Interfaces.IBeverageController;
import Controller.MainController;
import Domain.Restaurant.Beverage;
import Repository.Restaurant.BeverageRepository;

public class BeverageController extends MainController<Beverage> implements IBeverageController {
    private static BeverageController instance;

    public BeverageController() {
        super(BeverageRepository.getInstance());
    }

    public static BeverageController getInstance() {
        if(instance == null) {
            instance = new BeverageController();
        }
        return instance;
    }
}
