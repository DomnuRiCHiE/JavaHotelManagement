package Controller.Hotel;

import Controller.Interfaces.IRoomController;
import Controller.MainController;
import Domain.Hotel.Room;
import Repository.Hotel.RoomRepository;
import Repository.Interfaces.IRoomRepository;

public class RoomController extends MainController<Room> implements IRoomController {
    private static RoomController instance;
    private final IRoomRepository roomRepositoryInterface;

    private RoomController(RoomRepository roomRepository) {
        super(roomRepository);
        roomRepositoryInterface = roomRepository;
    }

    public static RoomController getInstance() {
        if(instance == null) {
            instance = new RoomController(RoomRepository.getInstance());
        }
        return instance;
    }
}
