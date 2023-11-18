package Controller.Restaurant;

import Controller.Interfaces.IAlcoholicBeveragesController;
import Controller.MainController;
import Domain.Restaurant.AlcoholicBeverages;
import Repository.Restaurant.AlcoholicBeverageRepository;

public class AlcoholicBeveragesController extends MainController<AlcoholicBeverages> implements IAlcoholicBeveragesController {
    private static AlcoholicBeveragesController instance;

    public AlcoholicBeveragesController() {
        super(AlcoholicBeverageRepository.getInstance());
    }

    public static AlcoholicBeveragesController getInstance() {
        if (instance == null) {
            instance = new AlcoholicBeveragesController();
        }
        return instance;
    }
}
