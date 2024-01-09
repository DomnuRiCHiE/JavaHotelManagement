package com.example.demo.Proxy;

import com.example.demo.Models.Room;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * customised interface for room repository
 */

public interface ICustomRoomRepository {
    Optional<List<Room>> findByNumber(@Param("roomNumber") Integer roomNumber);
}
