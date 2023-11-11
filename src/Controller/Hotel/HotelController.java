package Controller.Hotel;

import Controller.MainController;
import Domain.Hotel.Hotel;
import Repository.Hotel.HotelRepository;

public class HotelController extends MainController<Hotel> {
    private static HotelController instance;

    private HotelController() {
        super(HotelRepository.getInstance());
    }

    public static HotelController getInstance() {
        if(instance == null) {
            instance = new HotelController();
        }
        return instance;
    }
}