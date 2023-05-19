package com.example.spring_restfull_jpa_repo_tut.service;

import com.example.spring_restfull_jpa_repo_tut.entity.Employee;

import java.util.List;

// Step 3: After that Create the Implementation Layer
public interface EmployeeService {
    Employee getEmployeeById(long id);

    List<Employee> getAllEmployees();
}
