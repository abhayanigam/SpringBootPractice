package com.example.employeedetails.dao;

import com.example.employeedetails.model.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Employee> hashOperations;

    private final String reference = "Employee";

    @Override
    public void createEmployee(Employee emp) {
        hashOperations.putIfAbsent(reference, emp.getEmpId(), emp);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return hashOperations.get(reference,id);
    }

    @Override
    public Map<Integer, Employee> getEmployees() {
        return hashOperations.entries(reference);
    }

    @Override
    public void updateEmployee(Employee emp) {
        hashOperations.put(reference,emp.getEmpId(),emp);
    }

    @Override
    public void deleteEmployee(Integer id) {
        hashOperations.delete(reference,id);
    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        hashOperations.putAll(reference,map);
    }
}
