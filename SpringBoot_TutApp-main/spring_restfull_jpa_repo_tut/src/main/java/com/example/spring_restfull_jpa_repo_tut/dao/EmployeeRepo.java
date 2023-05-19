package com.example.spring_restfull_jpa_repo_tut.dao;

import com.example.spring_restfull_jpa_repo_tut.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Step 2: After that Create the Service Layer
@Repository("employeeRepository")
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
