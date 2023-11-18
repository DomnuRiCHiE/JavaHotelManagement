package Controller.Hotel;

import Controller.Interfaces.IBookingController;
import Controller.MainController;
import Domain.Hotel.Booking;
import Repository.Hotel.BookingRepository;

public class BookingController extends MainController<Booking> implements IBookingController {
    private static BookingController instance;

    private BookingController() {
        super(BookingRepository.getInstance());
    }

    public static BookingController getInstance() {
        if(instance == null) {
            instance = new BookingController();
        }
        return instance;
    }
}
