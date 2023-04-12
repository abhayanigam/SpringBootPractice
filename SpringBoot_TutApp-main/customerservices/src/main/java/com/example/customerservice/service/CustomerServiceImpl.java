package com.example.customerservice.service;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class CustomerServiceImpl implements CustomerService {
//    public static Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(Integer customerId) {
        Customer customer = customerRepository.getCustomer(customerId);
        return customer;
    }

    public void deleteCustomer(Integer customerId) {

        customerRepository.deleteCustomer(customerId);
    }

    public void updateCustomer(Customer customer) {

        customerRepository.updateCustomer(customer);

    }

    public Integer createCustomer(Customer customer) {
        Integer customerId = customerRepository.createCustomer(customer);
        return customerId;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }
}
