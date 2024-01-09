package com.example.demo.Service.Observer;

import com.example.demo.Models.Item;


/**
 * Interface for implementing Obsrver Pattern for Item Service
 */

public interface IObserverDeletedItem {
    void updateDeletedItem(Item item);
}
