package com.example.demo.Controller;

import com.example.demo.Models.Restaurant;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for implementing restaurant business logic
 * Extends BaseController
 */

@RestController
@RequestMapping("/restaurant")
public class RestaurantController extends BaseController<Restaurant, UUID> {
    @Autowired
    public RestaurantController(BaseService<Restaurant, UUID> service) {
        super(service);
    }
}
