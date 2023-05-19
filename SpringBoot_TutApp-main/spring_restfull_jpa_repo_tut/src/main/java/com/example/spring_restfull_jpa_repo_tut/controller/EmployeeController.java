package com.example.spring_restfull_jpa_repo_tut.controller;

import com.example.spring_restfull_jpa_repo_tut.entity.Employee;
import com.example.spring_restfull_jpa_repo_tut.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Step 5 : Initialize Sample Data in main class
@RestController
@RequestMapping(
        path = "/employees"
)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable("id") long id) {
        return employeeService.getEmployeeById(id);
    }
}
