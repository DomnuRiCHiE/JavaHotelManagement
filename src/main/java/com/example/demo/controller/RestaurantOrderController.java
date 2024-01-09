package com.example.demo.Controller;

import com.example.demo.Models.RestaurantOrder;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for implementing restaurant order business logic
 * Extends BaseController
 */

@RestController
@RequestMapping("/restaurantOrder")
public class RestaurantOrderController extends BaseController<RestaurantOrder, UUID> {
    @Autowired
    public RestaurantOrderController(BaseService<RestaurantOrder, UUID> service) {
        super(service);
    }
}
