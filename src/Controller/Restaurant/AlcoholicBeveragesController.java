package Controller.Restaurant;

import Controller.Interfaces.IAlcoholicBeveragesController;
import Controller.MainController;
import Domain.Restaurant.AlcoholicBeverages;
import Repository.Interfaces.IAlcoholicBeverageRepository;
import Repository.Restaurant.AlcoholicBeverageRepository;
import java.util.ArrayList;

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

    public void add(AlcoholicBeverages object) {
        super.add(object);
    }

    public void delete(AlcoholicBeverages object) {
        super.delete(object);
    }

    public void update(AlcoholicBeverages object1, AlcoholicBeverages object2) {
        super.update(object1, object2);
    }

    public ArrayList<AlcoholicBeverages> getAll() {
        return super.getAll();
    }
}
