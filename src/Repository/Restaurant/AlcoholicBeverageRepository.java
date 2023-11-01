package Repository.Restaurant;

import Domain.Restaurant.AlcoholicBeverages;
import Repository.IRepository;

import java.util.ArrayList;

public class AlcoholicBeverageRepository implements IRepository<AlcoholicBeverages> {
    private final ArrayList<AlcoholicBeverages> alcoholicBeverages;
    private static AlcoholicBeverageRepository instance;

    private AlcoholicBeverageRepository() {
        alcoholicBeverages = new ArrayList<>();
    }

    public static AlcoholicBeverageRepository getInstance() {
        if(instance == null) {
            instance = new AlcoholicBeverageRepository();
        }
        return instance;
    }

    public int length() {
        return alcoholicBeverages.size();
    }


    @Override
    public void add(AlcoholicBeverages object) {
        if(!alcoholicBeverages.contains(object)) {
            alcoholicBeverages.add(object);
        }
    }

    @Override
    public void update(AlcoholicBeverages object1, AlcoholicBeverages object2) {
        if(alcoholicBeverages.contains(object1)) {
            alcoholicBeverages.remove(object1);
            alcoholicBeverages.add(object2);
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
        return new ArrayList<>(alcoholicBeverages);
    }
}
