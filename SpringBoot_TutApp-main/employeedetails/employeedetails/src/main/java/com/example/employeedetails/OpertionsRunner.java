package com.example.employeedetails;

import com.example.employeedetails.dao.EmployeeDao;
import com.example.employeedetails.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OpertionsRunner implements CommandLineRunner {

    @Autowired
    private EmployeeDao empDao;

    @Override
    public void run(String... args) throws Exception {
        empDao.createEmployee(new Employee(11, "Emp0", 2150.0));

        empDao.saveAllEmployees(
                Map.of( 12, new Employee(12, "Emp1", 2396.0),
                        13, new Employee(13, "Emp2", 2499.5),
                        14  , new Employee(14, "Emp4", 2324.75)
                )
        );

        empDao.updateEmployee(new Employee(14, "14", 2325.25));

        empDao.deleteEmployee(11);

        empDao.getEmployees().forEach((k,v) -> System.out.println(k +" : "+v));

        System.out.println("Emp details for 12 : " + empDao.getEmployee(12));
    }
}
