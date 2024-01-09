package com.example.demo.Service;

import com.example.demo.Repository.JPA.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for extracting Menu repository info
 */


@Service
public class MenuService {
    private final MenuRepository repository;

    @Autowired
    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }
}
