package com.example.spring_restfull_jpa_repo_tut.service;

import com.example.spring_restfull_jpa_repo_tut.dao.EmployeeRepo;
import com.example.spring_restfull_jpa_repo_tut.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Step 4: After that Create the Controller Layer
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepository;

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
