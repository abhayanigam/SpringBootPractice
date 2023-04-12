package com.example.employees.dao;

import com.example.employees.entity.Employees;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employees> {
    @Override
    public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employees employees = new Employees();
        employees.setId(rs.getInt("Id"));
        employees.setName(rs.getString("name"));
        employees.setSalary(rs.getInt("salary"));

        return employees;
    }
}
