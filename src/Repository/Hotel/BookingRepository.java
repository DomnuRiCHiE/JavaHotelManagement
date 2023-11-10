package Repository.Hotel;

import Domain.Hotel.Booking;
import Repository.MainRepository;

public class BookingRepository extends MainRepository<Booking> {
    private static BookingRepository instance;

    private BookingRepository() {
        super();
    }

    public static BookingRepository getInstance() {
        if(instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }
}
