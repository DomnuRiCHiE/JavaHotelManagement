package Controller.Hotel;

import Controller.Interfaces.IHotelController;
import Controller.MainController;
import Domain.Hotel.Hotel;
import Repository.Hotel.HotelRepository;
import Repository.Interfaces.IHotelRepository;

public class HotelController extends MainController<Hotel> implements IHotelController {
    private static HotelController instance;
    private final IHotelRepository hotelRepositoryInterface;

    private HotelController(HotelRepository hotelRepository) {
        super(hotelRepository);
        hotelRepositoryInterface = hotelRepository;
    }

    public static HotelController getInstance() {
        if(instance == null) {
            instance = new HotelController(HotelRepository.getInstance());
        }
        return instance;
    }


}
