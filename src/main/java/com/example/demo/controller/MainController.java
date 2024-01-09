package com.example.demo.Controller;

import com.example.demo.Service.MainService;
import com.example.demo.Factory.RepoTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for running main app business logic
 */

@RestController
public class MainController {
    private final MainService service;

    @Autowired
    MainController(MainService service) {
        this.service = service;
    }

    @GetMapping("")
    public String welcome() {
        return service.welcome();
    }

    @PostMapping("/selectRepository/{value}")
    public String selectRepositoryType(@PathVariable(value = "value") String value) {
        System.out.println("Here");
        if (value.equals("jpa")) {
            service.selectRepoType(RepoTypes.JPA);
            return "Jpa repository selected..";
        }
        else {
            service.selectRepoType(RepoTypes.InMemory);
            return "In memory repository selected..";
        }

    }
}
