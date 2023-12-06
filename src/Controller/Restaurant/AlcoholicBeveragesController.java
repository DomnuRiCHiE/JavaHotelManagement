package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.AlcoholicBeverages;
import Repository.Restaurant.AlcoholicBeverageRepository;
import DAO.AlcoholicBeverageDAO;

import java.util.ArrayList;

public class AlcoholicBeveragesController extends MainController<AlcoholicBeverages> {
    public AlcoholicBeveragesController(AlcoholicBeverageRepository alcoholicBeverageRepository, AlcoholicBeverageDAO alcoholicBeverageDAO) {
        super(alcoholicBeverageRepository, alcoholicBeverageDAO);
    }

    @Override
    public void add(AlcoholicBeverages object) {
        DAO_repo.addEntityDAO(object);
    }

    @Override
    public void update(AlcoholicBeverages object1, AlcoholicBeverages object2) {
        DAO_repo.updateEntityDAO(object2);
    }

    @Override
    public void delete(AlcoholicBeverages object) {
        DAO_repo.deleteEntityDAO(object);

    }

    @Override
    public ArrayList<AlcoholicBeverages> getAll() {
        return DAO_repo.getAllEntitiesDAO();
    }
}
