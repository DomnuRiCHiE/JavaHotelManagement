package Repository.Hotel;

import Domain.Hotel.Room;
import Repository.MainRepository;

public class RoomRepository extends MainRepository<Room> {
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
