package com.example.demo.Controller;

import com.example.demo.Models.Client;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for implementing client business logic
 * Extends BaseController
 */

@RestController
@RequestMapping("/client")
public class ClientController extends BaseController<Client, UUID>{
    @Autowired
    public ClientController(BaseService<Client, UUID> service) {
        super(service);
    }
}
