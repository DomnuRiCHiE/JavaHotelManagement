package com.example.demo.Controller;

import com.example.demo.Models.Person;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for implementing person business logic
 * Extends BaseController
 */

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<Person, UUID> {
    @Autowired
    public PersonController(BaseService<Person, UUID> service) {
        super(service);
    }
}
