package com.example.demo.Controller;

import com.example.demo.Models.Employee;
import com.example.demo.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController<Employee, UUID>{
    @Autowired
    public EmployeeController(BaseService<Employee, UUID> service) {
        super(service);
    }
}
