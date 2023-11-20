package Controller.Hotel;

import Controller.Interfaces.IRoomController;
import Controller.MainController;
import Domain.Hotel.Room;
import Repository.Hotel.RoomRepository;
import Repository.Interfaces.IRoomRepository;
import java.util.ArrayList;

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

    public void add(Room object) {
        super.add(object);
    }

    public void delete(Room object) {
        super.delete(object);
    }

    public void update(Room object1, Room object2) {
        super.update(object1, object2);
    }

    public ArrayList<Room> getAll() {
        return super.getAll();
    }
}
