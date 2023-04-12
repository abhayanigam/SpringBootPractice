package com.example.employees.service;

import com.example.employees.dao.EmployeesDao;
import com.example.employees.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService{

    @Autowired
    private EmployeesDao employeesDao;

    @Override
    public Employees getEmployee(Integer empId) {
        Employees employees = employeesDao.getEmployee(empId);
        return employees;
    }

    @Override
    public List<Employees> getEmployeesFromTwoTables() {
        return employeesDao.getEmployeesFromTwoTables();
    }

    @Override
    public Integer createEmployees(Employees employees) {
        Integer employeeId = employeesDao.createEmployees(employees);
        return employeeId;
    }

    @Override
    public void updateEmployees(Employees employees) {
        employeesDao.updateEmployees(employees);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        employeesDao.deleteEmployee(empId);
    }
}
