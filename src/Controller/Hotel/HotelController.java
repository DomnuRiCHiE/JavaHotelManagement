package Controller.Hotel;

import Controller.MainController;
import Domain.Hotel.Hotel;
import Repository.Hotel.HotelRepository;

public class HotelController extends MainController<Hotel> {
    public HotelController(HotelRepository hotelRepository) {
        super(hotelRepository);
    }
}
