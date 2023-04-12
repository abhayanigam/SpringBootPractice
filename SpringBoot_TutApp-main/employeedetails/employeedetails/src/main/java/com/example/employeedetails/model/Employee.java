package com.example.employeedetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
    private Integer empId;
    private String empName;
    private Double empSalary;
}
