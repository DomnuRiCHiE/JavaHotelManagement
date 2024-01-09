package com.example.demo.Controller;

import com.example.demo.Models.Menu;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu, UUID> {
    @Autowired
    public MenuController(BaseService<Menu, UUID> service) {
        super(service);
    }
}
