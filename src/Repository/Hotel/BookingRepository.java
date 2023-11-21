package Repository.Hotel;

import Domain.Hotel.Booking;
import Repository.Interfaces.IBookingRepository;
import Repository.MainRepository;

import java.util.ArrayList;

public class BookingRepository extends MainRepository<Booking> implements IBookingRepository {
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
