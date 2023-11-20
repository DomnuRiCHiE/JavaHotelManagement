package Controller.Hotel;

import Controller.Interfaces.IHotelController;
import Controller.MainController;
import Domain.Hotel.Hotel;
import Repository.Hotel.HotelRepository;
import Repository.Interfaces.IHotelRepository;
import java.util.ArrayList;

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

    public void add(Hotel object) {
        super.add(object);
    }

    public void delete(Hotel object) {
        super.delete(object);
    }

    public void update(Hotel object1, Hotel object2) {
        super.update(object1, object2);
    }

    public ArrayList<Hotel> getAll() {
        return super.getAll();
    }
}
