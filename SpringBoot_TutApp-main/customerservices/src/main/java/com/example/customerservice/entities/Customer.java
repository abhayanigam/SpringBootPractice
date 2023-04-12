package com.example.customerservice.entities;

import java.sql.Timestamp;

public class Customer {


    private Integer id;

    private String name;

    private String email;
    private String mobileNumber;
    private Timestamp createdOn;


    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {

        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }
}
