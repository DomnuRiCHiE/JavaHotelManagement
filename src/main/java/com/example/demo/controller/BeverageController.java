package com.example.demo.Controller;

import com.example.demo.Service.BeverageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beverage")
public class BeverageController {

    private final BeverageService beverageService;

    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }
}
