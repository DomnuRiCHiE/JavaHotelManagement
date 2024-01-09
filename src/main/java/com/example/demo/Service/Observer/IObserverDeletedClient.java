package com.example.demo.Service.Observer;

import com.example.demo.Models.Client;

/**
 * Interface for implementing Obsrver Pattern for Client Service
 */
public interface IObserverDeletedClient {
    void deletedClient(Client client);
}
