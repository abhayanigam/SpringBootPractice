package com.example.employeedetails.service;

import com.example.employeedetails.dao.EmployeeDao;
import com.example.employeedetails.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    public EmployeeDao employeeDao;
    @Override
    public void createEmployee(Employee emp) {
        employeeDao.createEmployee(emp);
    }

    @Override
    public Employee getEmployee(Integer id) {
        Employee employee = employeeDao.getEmployee(id);
        return employee;
    }

    @Override
    public Map<Integer, Employee> getEmployees() {
        Map<Integer, Employee> var = employeeDao.getEmployees();
        return var;
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeDao.updateEmployee(emp);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        employeeDao.saveAllEmployees(map);
    }
}
