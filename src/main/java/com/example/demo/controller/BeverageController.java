package com.example.demo.Controller;

import com.example.demo.Models.Beverage;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/beverage")
public class BeverageController extends BaseController<Beverage, UUID>{
    @Autowired
    public BeverageController(BaseService<Beverage, UUID> service) {
        super(service);
    }
}
