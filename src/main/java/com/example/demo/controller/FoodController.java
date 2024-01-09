package com.example.demo.Controller;

import com.example.demo.Models.Food;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for implementing food business logic
 * Extends BaseController
 */

@RestController
@RequestMapping("/food")
public class FoodController extends BaseController<Food, UUID>{
    @Autowired
    public FoodController(BaseService<Food, UUID> service) {
        super(service);
    }
}
