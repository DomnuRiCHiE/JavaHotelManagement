package Controller.Hotel;

import Controller.MainController;
import Domain.Hotel.Room;
import Repository.Hotel.RoomRepository;

public class RoomController extends MainController<Room> {
    public RoomController(RoomRepository roomRepository) {
        super(roomRepository);
    }
}
