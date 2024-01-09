package com.example.demo.Factory;

import com.example.demo.Models.Room;
import com.example.demo.Repository.InMemory.IRepository;

import java.util.UUID;

public interface IRepoFactory<Entity, ID> {
    IRepository<Room, UUID> buildIRepository(RepoTypes type);
}
