package Controller.Hotel;

import Controller.Interfaces.IBookingController;
import Controller.MainController;
import Domain.Hotel.Booking;
import Repository.Hotel.BookingRepository;
import Repository.Interfaces.IBookingRepository;

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


}
