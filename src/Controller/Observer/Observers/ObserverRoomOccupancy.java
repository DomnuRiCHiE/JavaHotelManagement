package Controller.Observer.Observers;

import Domain.Hotel.Room;

public class ObserverRoomOccupancy implements IObserverRoomOccupancy {
    public String updateRoom;
    private String lastUpdate;

    @Override
    public void updateRoomOccupancy(Room room) {
        lastUpdate = String.valueOf(room.isOccupied());
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}
