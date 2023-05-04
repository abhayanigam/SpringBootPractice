package com.example.conatainer_tut.qualifierannowithautowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeQualifier {
    @Autowired
    @Qualifier("address2")
    private AddressQualifier address;

    public AddressQualifier getAddress() {
        return address;
    }

//    @Autowired -- we can use here
    public void setAddress(AddressQualifier address) {
        this.address = address;
    }

    public EmployeeQualifier(AddressQualifier address) {
        this.address = address;
    }

//    @Autowired -- we can use here
    public EmployeeQualifier() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                '}';
    }
}
