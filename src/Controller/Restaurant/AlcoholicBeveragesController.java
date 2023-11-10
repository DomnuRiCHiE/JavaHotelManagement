package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.AlcoholicBeverages;
import Repository.Restaurant.AlcoholicBeverageRepository;

public class AlcoholicBeveragesController extends MainController<AlcoholicBeverages> {
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
