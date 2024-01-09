package com.example.demo.Service;

import com.example.demo.Repository.JPA.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeverageService {
    private final BeverageRepository repository;

    @Autowired
    public BeverageService(BeverageRepository repository) {
        super();
        this.repository = repository;
    }


}
