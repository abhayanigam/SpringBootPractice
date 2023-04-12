package com.example.employeedetails.dao;

import com.example.employeedetails.model.Employee;

import java.util.Map;

public interface EmployeeDao {
    void createEmployee(Employee emp);

    Employee getEmployee(Integer id);
    Map<Integer, Employee> getEmployees();

    void updateEmployee(Employee emp);

    void deleteEmployee(Integer id);

    void saveAllEmployees(Map<Integer, Employee> map);
}
