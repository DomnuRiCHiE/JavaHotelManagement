package com.example.demo.Service;

import com.example.demo.Factory.RepoTypes;
import com.example.demo.Proxy.RoomProxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Service for running the app
 */


@Service
public class MainService {
    private final RoomProxyRepository roomProxyRepository;

    @Autowired
    public MainService(RoomProxyRepository roomProxyRepository) {
        this.roomProxyRepository = roomProxyRepository;
    }

    public void selectRepoType(RepoTypes type)
    {
        switch (type)
        {
            case InMemory -> roomProxyRepository.selectInMemory();
            case JPA -> roomProxyRepository.selectJpa();
        }
    }

    public String welcome()
    {
        return "Welcome! Please select repository type.";
    }
}
