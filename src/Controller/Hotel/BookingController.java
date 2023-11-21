package Controller.Hotel;

import Controller.Interfaces.IBookingController;
import Controller.MainController;
import Domain.Hotel.Booking;
import Repository.Hotel.BookingRepository;
import Repository.Interfaces.IBookingRepository;
import java.util.ArrayList;

public class BookingController extends MainController<Booking> implements IBookingController {
    private static BookingController instance;
    private final IBookingRepository bookingRepositoryInstance;

    private BookingController(BookingRepository bookingRepository) {
        super(bookingRepository);
        bookingRepositoryInstance = bookingRepository;
    }

    public static BookingController getInstance() {
        if(instance == null) {
            instance = new BookingController(BookingRepository.getInstance());
        }
        return instance;
    }

    public void add(Booking object) {
        super.add(object);
    }

    public void delete(Booking object) {
        super.delete(object);
    }

    public void update(Booking object1, Booking object2) {
        super.update(object1, object2);
    }

    public ArrayList<Booking> getAll() {
        return super.getAll();
    }
}
