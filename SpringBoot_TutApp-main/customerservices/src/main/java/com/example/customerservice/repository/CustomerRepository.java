package com.example.customerservice.repository;

import com.example.customerservice.entities.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {


    public Customer getCustomer(Integer customerId);

    public void deleteCustomer(Integer customerId);

    public void updateCustomer(Customer customer);

    public Integer createCustomer(Customer customer);

    List<Customer> getCustomers();

}
