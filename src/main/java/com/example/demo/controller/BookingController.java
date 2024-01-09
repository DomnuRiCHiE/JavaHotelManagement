package com.example.demo.Controller;

import com.example.demo.Models.Booking;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController extends BaseController<Booking, UUID>{
    @Autowired
    public BookingController(BaseService<Booking, UUID> service) {
        super(service);
    }
}
