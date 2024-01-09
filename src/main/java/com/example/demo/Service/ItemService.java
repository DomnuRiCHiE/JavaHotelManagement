package com.example.demo.Service;

import com.example.demo.Models.Item;
import com.example.demo.Repository.JPA.ItemRepository;
import com.example.demo.Service.Observer.IObserverDeletedItem;
import com.example.demo.Service.Subject.ISubjectDeletedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService implements IObserverDeletedItem, ISubjectDeletedItem {
    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addObserver(IObserverDeletedItem observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedItem observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyDeletedItem(Item item) {
        for(IObserverDeletedItem observer : observerList) {
            observer.updateDeletedItem(item);
        }
    }

    @Override
    public void updateDeletedItem(Item item) {}
}
