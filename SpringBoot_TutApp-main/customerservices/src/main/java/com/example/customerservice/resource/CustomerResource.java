package com.example.customerservice.resource;


import com.example.customerservice.entities.Customer;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(
        path = "/customerservice/v1/customers",
        produces = "application/json",
        consumes = "application/json")
public class CustomerResource {
//    public static Logger log = LoggerFactory.getLogger(CustomerResource.class);
    @Autowired
    private CustomerService customerService;

//    public CustomerResource() {}

    @PostMapping
    public Customer createCustomer(
            @RequestBody Customer customer) {

        Integer id = customerService.createCustomer(customer);
        Customer var = customerService.getCustomer(id);
        if (var == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Customer could not be created due to bad request");
        }
        return var;
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Integer customerId,
            @RequestBody Customer customer) {
        customer.setId(customerId);
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId) {
        Customer var = customerService.getCustomer(customerId);
        if (var == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                        String.format("Customer with identifier %d does not exists", customerId));
        }
        return var;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        List<Customer> customers = customerService.getCustomers();

        return customers;

    }
}
