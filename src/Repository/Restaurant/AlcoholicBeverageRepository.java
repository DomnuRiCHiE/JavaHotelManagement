package Repository.Restaurant;

import Domain.Restaurant.AlcoholicBeverages;
import Repository.Interfaces.IAlcoholicBeverageRepository;
import Repository.MainRepository;

public class AlcoholicBeverageRepository extends MainRepository<AlcoholicBeverages> implements IAlcoholicBeverageRepository {
    private static AlcoholicBeverageRepository instance;

    private AlcoholicBeverageRepository() {
        super();
    }

    public static AlcoholicBeverageRepository getInstance() {
        if(instance == null) {
            instance = new AlcoholicBeverageRepository();
        }
        return instance;
    }

    public int length() {
        return arrayList.size();
    }
}
