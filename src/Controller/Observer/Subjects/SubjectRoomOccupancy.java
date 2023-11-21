package Controller.Observer.Subjects;

import Controller.Observer.Observers.IObserverRoomOccupancy;
import Domain.Hotel.Room;

public class SubjectRoomOccupancy implements ISubjectRoomOccupancy {

    @Override
    public void addObserver(IObserverRoomOccupancy observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverRoomOccupancy observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Room room) {
        for(IObserverRoomOccupancy observer: observerList) {
            observer.updateRoomOccupancy(room);
        }
    }
}
