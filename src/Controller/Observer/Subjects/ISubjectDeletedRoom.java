package Controller.Observer.Subjects;

import Controller.Observer.Observers.IObserverDeletedRoom;
import Domain.Hotel.Room;
import java.util.ArrayList;

public interface ISubjectDeletedRoom {
    ArrayList<IObserverDeletedRoom> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedRoom observer);
    void removeObserver(IObserverDeletedRoom observer);
    void notifyDeletedRoom(Room room);
}
