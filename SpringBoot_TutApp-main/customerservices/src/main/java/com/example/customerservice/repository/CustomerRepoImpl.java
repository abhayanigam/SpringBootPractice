package com.example.customerservice.repository;

import com.example.customerservice.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomerRepoImpl implements CustomerRepository {

    public static Logger log = LoggerFactory.getLogger(CustomerRepoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String selectCustomerQuery =
            " SELECT id, name, email, mobileNumber, created_on  FROM customer  WHERE id =  ?";

    @Override
    public Customer getCustomer(Integer customerId) {
        try {
            RowMapper<Customer> rowMapper = new CustomerRowMapper();


            Customer customer = jdbcTemplate.queryForObject(selectCustomerQuery, rowMapper, new Object[]{customerId});

            return customer;
        } catch (DataAccessException e) {
            log.debug("Error occurred in fetching Customer from DB", e);
            return null;
        }
    }


    private static String selectCustomersQuery =
            " SELECT id, name, email, mobileNumber, created_on  FROM customer ";

    @Override
    public List<Customer> getCustomers() {
        try {
            RowMapper<Customer> rowMapper = new CustomerRowMapper();
            List<Customer> customers = jdbcTemplate.query(selectCustomersQuery, rowMapper);

            return customers;

        } catch (DataAccessException e) {
            log.debug("Error occurred in fetching Customer from DB", e);
            return null;
        }
    }


    public static String deleteCustomerQuery =
            " DELETE FROM customer" + " WHERE (id =   ?)";


    @Override
    public void deleteCustomer(Integer customerId) {

        jdbcTemplate.update(deleteCustomerQuery, customerId);

    }

    public static String updateCustomerQuery =
            " UPDATE customer"
                    + " SET name =  ?, email =  ?, mobileNumber =  ?"
                    + " WHERE (id =  ?)";

    @Override
    public void updateCustomer(Customer customer) {
        Integer customerId = customer.getId();
        if(customerId == null) {
            return;
        }
        Customer existingCustomer = getCustomer(customerId);
        if (existingCustomer == null) {
            throw new RuntimeException(
                    String.format("Customer with id {} does not exists", customer.getId()));
        }


        jdbcTemplate.update(updateCustomerQuery, customer.getName(), customer.getEmail(), customer.getMobileNumber(), customerId);


    }

    public static String createCustomerQuery =
            " INSERT INTO customer"
                    + "  (name, email, mobileNumber, created_on)"
                    + " VALUES (?, ?, ?, ?)";

    @Override
    public Integer createCustomer(Customer customer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();


        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con
                        .prepareStatement(createCustomerQuery);
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getEmail());
                ps.setString(3, customer.getMobileNumber());
                ps.setTimestamp(4, Timestamp.from(Instant.now()));
                return ps;
            }
        };
        jdbcTemplate.update(psc, keyHolder);
        customer.setId(keyHolder.getKey().intValue());

        return customer.getId();
    }


}
