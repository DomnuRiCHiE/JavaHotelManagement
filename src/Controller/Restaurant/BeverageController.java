package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.Beverage;
import Repository.Restaurant.BeverageRepository;

public class BeverageController extends MainController<Beverage> {
    public BeverageController(BeverageRepository beverageRepository) {
        super(beverageRepository);
    }
}
