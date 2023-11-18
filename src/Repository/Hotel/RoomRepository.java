package Repository.Hotel;

import Domain.Hotel.Room;
import Repository.Interfaces.IRoomRepository;
import Repository.MainRepository;

public class RoomRepository extends MainRepository<Room> implements IRoomRepository {
    private static RoomRepository instance;

    private RoomRepository() {
        super();
    }

    public static RoomRepository getInstance() {
        if(instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }
}
