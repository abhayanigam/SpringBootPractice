package com.example.conatainer_tut.autowireannotut;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeAutoAnno {
    @Autowired
    private AddressAutoAnno address;

    public AddressAutoAnno getAddress() {
        return address;
    }

//    @Autowired -- we can use here
    public void setAddress(AddressAutoAnno address) {
        this.address = address;
    }

    public EmployeeAutoAnno(AddressAutoAnno address) {
        this.address = address;
    }

//    @Autowired -- we can use here
    public EmployeeAutoAnno() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                '}';
    }
}
