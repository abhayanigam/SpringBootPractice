package com.example.customerservice.repository;

import com.example.customerservice.entities.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("email"));
        customer.setMobileNumber(rs.getString("mobileNumber"));
        customer.setCreatedOn(rs.getTimestamp("created_on"));

        return customer;
    }
}
