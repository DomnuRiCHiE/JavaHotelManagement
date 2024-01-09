package com.example.demo.Controller;

import com.example.demo.Models.Room;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for implementing room business logic
 * Extends BaseController
 */

@RestController
@RequestMapping("/room")
public class RoomController extends BaseController<Room, UUID> {
    @Autowired
    public RoomController(BaseService<Room, UUID> service) {
        super(service);
    }
}
