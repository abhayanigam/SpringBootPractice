package com.example.customerservice.repository;

import com.example.customerservice.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    public static Logger log = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static String selectCustomerQuery =
            " SELECT id, name, email, mobileNumber, created_on  FROM customer  WHERE id =  :customerId";

    @Override
    public Customer getCustomer(Integer customerId) {
        try {
            RowMapper<Customer> rowMapper = new CustomerRowMapper();
            return jdbcTemplate.queryForObject(
                    selectCustomerQuery, Collections.singletonMap("customerId", customerId), rowMapper);
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
            " DELETE FROM customer" + " WHERE (id =   :customerId)";


    @Override
    public void deleteCustomer(Integer customerId) {
        Map<String, Integer> namedParameters = new HashMap<>();
        namedParameters.put("customerId", customerId);
        jdbcTemplate.update(deleteCustomerQuery, namedParameters);
    }

    public static String updateCustomerQuery =
            " UPDATE customer"
                    + " SET name =  :name, email =  :email, mobileNumber =  :mobileNumber"
                    + " WHERE (id =  :id)";

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

        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("id", customer.getId());
        namedParameters.put("name", customer.getName());
        namedParameters.put("email", customer.getEmail());
        namedParameters.put("mobileNumber", customer.getMobileNumber());
        jdbcTemplate.update(updateCustomerQuery, namedParameters);


    }

    public static String createCustomerQuery =
            " INSERT INTO customer"
                    + "  (name, email, mobileNumber, created_on)"
                    + " VALUES ( :name,  :email,  :mobileNumber, :createdOn)";

    @Override
    public Integer createCustomer(Customer customer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", customer.getName());
        namedParameters.addValue("email", customer.getEmail());
        namedParameters.addValue("mobileNumber", customer.getMobileNumber());
        namedParameters.addValue("createdOn", Timestamp.from(Instant.now()));
        
        jdbcTemplate.update(createCustomerQuery, namedParameters, keyHolder, new String[] {"id"});
        customer.setId(keyHolder.getKey().intValue());

        return customer.getId();
    }


}
