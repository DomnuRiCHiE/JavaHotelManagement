package Repository.Hotel;

import Domain.Hotel.Hotel;
import Repository.Interfaces.IHotelRepository;
import Repository.MainRepository;

public class HotelRepository extends MainRepository<Hotel> implements IHotelRepository {
    private static HotelRepository instance;

    private HotelRepository() {
        super();
    }

    public static HotelRepository getInstance() {
        if(instance == null) {
            instance = new HotelRepository();
        }
        return instance;
    }
}
