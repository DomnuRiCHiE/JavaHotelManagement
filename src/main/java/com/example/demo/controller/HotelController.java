package com.example.demo.Controller;

import com.example.demo.Models.Hotel;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/hotel")
public class HotelController extends BaseController<Hotel, UUID> {
    @Autowired
    public HotelController(BaseService<Hotel, UUID> service) {
        super(service);
    }
}
