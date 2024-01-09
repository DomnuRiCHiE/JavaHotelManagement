package com.example.demo.Service.Observer;

import com.example.demo.Models.Room;

/**
 * Interface for implementing Obsrver Pattern for Room Service
 */

public interface IObserverDeletedRoom {
    void updateRoomDeleted(Room room);
}
