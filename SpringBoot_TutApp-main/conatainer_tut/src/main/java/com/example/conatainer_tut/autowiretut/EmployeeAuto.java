package com.example.conatainer_tut.autowiretut;

public class Employee {
    private AddressAuto address;

    public AddressAuto getAddress() {
        return address;
    }

    public void setAddress(AddressAuto address) {
        this.address = address;
    }

    public Employee(AddressAuto address) {
        this.address = address;
    }

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
