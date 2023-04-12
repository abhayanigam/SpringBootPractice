package com.example.employees.service;

import com.example.employees.entity.Employees;

import java.util.List;

public interface EmployeesService {
    Employees getEmployee(Integer empId);

    List<Employees> getEmployeesFromTwoTables();

    Integer createEmployees(Employees employees);

    void updateEmployees(Employees employees);

    void deleteEmployee(Integer empId);
}
