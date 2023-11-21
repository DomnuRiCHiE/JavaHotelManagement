package Controller.Hotel;

import Controller.MainController;
import Domain.Hotel.Booking;
import Repository.Hotel.BookingRepository;

public class BookingController extends MainController<Booking> {
    public BookingController(BookingRepository bookingRepository) {
        super(bookingRepository);
    }
}
