package Controller.Observer.Subjects;

import Controller.Observer.Observers.IObserverRoomOccupancy;
import Domain.Hotel.Room;
import java.util.ArrayList;

public interface ISubjectRoomOccupancy {
    ArrayList<IObserverRoomOccupancy> observerList = new ArrayList<>();

    void addObserver(IObserverRoomOccupancy observer);
    void removeObserver(IObserverRoomOccupancy observer);
    void notifyObservers(Room room);
}
