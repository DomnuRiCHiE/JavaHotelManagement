package com.example.demo.Controller;

import com.example.demo.Models.Item;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController<Item, UUID> {
    @Autowired
    public ItemController(BaseService<Item, UUID> service) {
        super(service);
    }
}
