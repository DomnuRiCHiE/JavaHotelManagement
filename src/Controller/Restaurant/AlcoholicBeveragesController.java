package Controller.Restaurant;

import Controller.Interfaces.IAlcoholicBeveragesController;
import Controller.MainController;
import Domain.Restaurant.AlcoholicBeverages;
import Repository.Interfaces.IAlcoholicBeverageRepository;
import Repository.Restaurant.AlcoholicBeverageRepository;

public class AlcoholicBeveragesController extends MainController<AlcoholicBeverages> implements IAlcoholicBeveragesController {
    private static AlcoholicBeveragesController instance;
    private final IAlcoholicBeverageRepository alcoholicBeverageRepositoryInterface;

    public AlcoholicBeveragesController(AlcoholicBeverageRepository alcoholicBeverageRepository) {
        super(alcoholicBeverageRepository);
        alcoholicBeverageRepositoryInterface = alcoholicBeverageRepository;
    }

    public static AlcoholicBeveragesController getInstance() {
        if (instance == null) {
            instance = new AlcoholicBeveragesController(AlcoholicBeverageRepository.getInstance());
        }
        return instance;
    }
}
