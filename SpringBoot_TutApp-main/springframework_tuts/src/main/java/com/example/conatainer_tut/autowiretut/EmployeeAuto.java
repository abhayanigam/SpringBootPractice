package com.example.conatainer_tut.autowiretut;

public class EmployeeAuto {
    private AddressAuto address;

    public AddressAuto getAddress() {
        return address;
    }

    public void setAddress(AddressAuto address) {
        this.address = address;
    }

    public EmployeeAuto(AddressAuto address) {
        this.address = address;
    }

    public EmployeeAuto() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                '}';
    }
}
