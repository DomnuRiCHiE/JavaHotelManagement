package Controller.Restaurant;

import Controller.IController;
import Domain.Restaurant.AlcoholicBeverages;
import Repository.Restaurant.AlcoholicBeverageRepository;
import java.util.ArrayList;

public class AlcoholicBeveragesController implements IController<AlcoholicBeverages> {
    private final AlcoholicBeverageRepository alcoholicBeverageRepository;
    private static AlcoholicBeveragesController instance;

    public AlcoholicBeveragesController(AlcoholicBeverageRepository alcoholicBeverageRepository) {
        this.alcoholicBeverageRepository = alcoholicBeverageRepository;
    }

    public static AlcoholicBeveragesController getInstance(AlcoholicBeverageRepository alcoholicBeverageRepository) {
        if(instance == null) {
            instance = new AlcoholicBeveragesController(alcoholicBeverageRepository);
        }
        return instance;
    }

    @Override
    public void add(AlcoholicBeverages object) {
        alcoholicBeverageRepository.add(object);
    }

    @Override
    public void update(AlcoholicBeverages object) {
        alcoholicBeverageRepository.update(object);
    }

    @Override
    public void delete(AlcoholicBeverages object) {
        alcoholicBeverageRepository.delete(object);
    }

    @Override
    public ArrayList<AlcoholicBeverages> getAll() {
        return alcoholicBeverageRepository.getAll();
    }
}
