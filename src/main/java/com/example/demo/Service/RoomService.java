package com.example.demo.Service;

import com.example.demo.Models.Room;
import com.example.demo.Repository.JPA.RoomRepository;
import com.example.demo.Service.Observer.IObserverDeletedRoom;
import com.example.demo.Service.Subject.ISubjectDeletedRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IObserverDeletedRoom, ISubjectDeletedRoom {
    private final RoomRepository repository;

    @Autowired
    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addObserver(IObserverDeletedRoom observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedRoom observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyDeletedRoom(Room room) {
        for(IObserverDeletedRoom observer : observerList) {
            observer.updateRoomDeleted(room);
        }
    }

    @Override
    public void updateRoomDeleted(Room room) {}
}
