package com.example.demo.Service;

import com.example.demo.Repository.JPA.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    private final FoodRepository repository;

    @Autowired
    public FoodService(FoodRepository repository1) {
        this.repository = repository1;
    }
}
