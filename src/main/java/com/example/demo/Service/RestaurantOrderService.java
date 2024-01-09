package com.example.demo.Service;

import com.example.demo.Repository.JPA.RestaurantOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantOrderService {
    private final RestaurantOrderRepository repository;

    @Autowired
    public RestaurantOrderService(RestaurantOrderRepository repository) {
        this.repository = repository;
    }
}
