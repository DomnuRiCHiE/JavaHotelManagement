package Controller.Hotel;

import Controller.MainController;
import Domain.Hotel.Room;
import Repository.Hotel.RoomRepository;

public class RoomController extends MainController<Room> {
    private static RoomController instance;

    private RoomController() {
        super(RoomRepository.getInstance());
    }

    public static RoomController getInstance() {
        if(instance == null) {
            instance = new RoomController();
        }
        return instance;
    }
}
