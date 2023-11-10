package Repository.Hotel;

import Domain.Hotel.Hotel;
import Repository.MainRepository;

public class HotelRepository extends MainRepository<Hotel> {
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
