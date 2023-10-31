package Repository.Restaurant;

import Domain.Restaurant.AlcoholicBeverages;
import Repository.IRepository;

import java.util.ArrayList;

public class AlcoholicBeverageRepository implements IRepository<AlcoholicBeverages> {
    private final ArrayList<AlcoholicBeverages> alcoholicBeverages;
    private static AlcoholicBeverageRepository instance;

    private AlcoholicBeverageRepository() {
        alcoholicBeverages = new ArrayList<>();
        AlcoholicBeverages alcoholicBeverage1 = new AlcoholicBeverages("Kronenburg blanc", 10, "Refreshing beer", 330, 5);
        AlcoholicBeverages alcoholicBeverage2 = new AlcoholicBeverages("Guiness", 13, "Refreshing beer", 500, 7);
        AlcoholicBeverages alcoholicBeverage3 = new AlcoholicBeverages("Glennfiddich", 15, "12 year aged scotch", 100, 35);

        alcoholicBeverages.add(alcoholicBeverage1);
        alcoholicBeverages.add(alcoholicBeverage2);
        alcoholicBeverages.add(alcoholicBeverage3);
    }

    public static AlcoholicBeverageRepository getInstance() {
        if(instance == null) {
            instance = new AlcoholicBeverageRepository();
        }
        return instance;
    }


    @Override
    public void add(AlcoholicBeverages object) {
        if(!alcoholicBeverages.contains(object)) {
            alcoholicBeverages.add(object);
        }
    }

    @Override
    public void update(AlcoholicBeverages object) {
        if(alcoholicBeverages.contains(object)) {
            alcoholicBeverages.remove(object);
            alcoholicBeverages.add(object);
        }
    }

    @Override
    public void delete(AlcoholicBeverages object) {
        if(alcoholicBeverages.contains(object)) {
            alcoholicBeverages.remove(object);
        }
    }

    @Override
    public ArrayList<AlcoholicBeverages> getAll() {
        return new ArrayList<>();
    }
}
