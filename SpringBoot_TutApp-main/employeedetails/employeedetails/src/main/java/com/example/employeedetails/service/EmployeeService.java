package com.example.employeedetails.service;

import com.example.employeedetails.model.Employee;

import java.util.Map;

public interface EmployeeService {
    void createEmployee(Employee emp);

    Employee getEmployee(Integer id);
    Map<Integer, Employee> getEmployees();

    void updateEmployee(Employee emp);

    void deleteEmployee(Integer id);

    void saveAllEmployees(Map<Integer, Employee> map);
}
