package com.example.demo.Proxy;

import com.example.demo.Models.Room;
import com.example.demo.Repository.InMemory.IRepository;

import java.util.UUID;

public interface IRoomRepository extends IRepository<Room, UUID>, ICustomRoomRepository {
}
