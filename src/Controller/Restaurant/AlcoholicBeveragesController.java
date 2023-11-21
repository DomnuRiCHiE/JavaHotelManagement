package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.AlcoholicBeverages;
import Repository.Restaurant.AlcoholicBeverageRepository;

public class AlcoholicBeveragesController extends MainController<AlcoholicBeverages> {
    public AlcoholicBeveragesController(AlcoholicBeverageRepository alcoholicBeverageRepository) {
        super(alcoholicBeverageRepository);
    }
}
