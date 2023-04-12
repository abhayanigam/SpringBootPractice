package com.example.employees.dao;

import com.example.employees.entity.Employees;

import java.util.List;

public interface EmployeesDao {
    public Employees getEmployee(Integer empId);

    List<Employees> getEmployeesFromTwoTables();

    public Integer createEmployees(Employees employees);

    public void updateEmployees(Employees employees);

    public void deleteEmployee(Integer empId);
}
