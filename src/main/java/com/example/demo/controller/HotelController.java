package com.example.demo.Controller;

import com.example.demo.Models.Hotel;
import com.example.demo.Service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class HotelController {
    public final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    //@GetMapping -> GET(return) @PostMapping -> POST (void)
    @GetMapping(value = "add")
    public String add() {

        //var hotel = Hotel.getInstance();
        return "Sa adaugat";
    }
}
