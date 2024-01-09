package com.example.demo.Service.Subject;

import com.example.demo.Models.Item;
import com.example.demo.Service.Observer.IObserverDeletedItem;

import java.util.ArrayList;

public interface ISubjectDeletedItem {
    ArrayList<IObserverDeletedItem> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedItem observer);
    void removeObserver(IObserverDeletedItem observer);
    void notifyDeletedItem(Item item);
}
