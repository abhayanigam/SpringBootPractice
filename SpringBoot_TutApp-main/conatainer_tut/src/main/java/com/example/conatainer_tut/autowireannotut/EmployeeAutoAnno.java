package com.example.conatainer_tut.autowireannotut;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    @Autowired
    private Address address;

    public Address getAddress() {
        return address;
    }

//    @Autowired -- we can use here
    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(Address address) {
        this.address = address;
    }

//    @Autowired -- we can use here
    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                '}';
    }
}
