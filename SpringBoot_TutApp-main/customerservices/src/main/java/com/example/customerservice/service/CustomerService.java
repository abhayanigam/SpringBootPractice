package com.example.customerservice.service;

import com.example.customerservice.entities.Customer;

import java.util.List;

public interface CustomerService {

    public Customer getCustomer(Integer customerId);

    public void deleteCustomer(Integer customerId);

    public void updateCustomer(Customer customer);

    public Integer createCustomer(Customer customer);

    List<Customer> getCustomers();
}
