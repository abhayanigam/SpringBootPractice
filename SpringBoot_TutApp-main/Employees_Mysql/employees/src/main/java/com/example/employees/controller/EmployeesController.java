package com.example.employees.controller;

import com.example.employees.entity.Employees;
import com.example.employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(
        path = "/employeesservice/v1/employees",
        produces = "application/json",
        consumes = "application/json"
)
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/{empId}")
    public Employees getStudent(@PathVariable("empId") Integer empId){
        Employees var = employeesService.getEmployee(empId);
        if (var == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Student with identifier %d does not exists", empId));
        }
        return var;
    }

    @GetMapping
    public List<Employees> getStudents(){
        List<Employees> students = employeesService.getEmployeesFromTwoTables();
        return students;
    }

    @PostMapping
    public Employees createStudent(@RequestBody Employees employees){
        System.out.println("Hello");
        Integer id = employeesService.createEmployees(employees);
        Employees var = employeesService.getEmployee(id);
        if (var == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Student could not be created due to bad request");
        }
        return var;
    }

    @PutMapping("/{empId}")
    public void updateEmployee(@PathVariable("empId") Integer empId,@RequestBody Employees employees){
        employees.setId(empId);
        employeesService.updateEmployees(employees);
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable ("empId") Integer empId){
        employeesService.deleteEmployee(empId);
    }
}
