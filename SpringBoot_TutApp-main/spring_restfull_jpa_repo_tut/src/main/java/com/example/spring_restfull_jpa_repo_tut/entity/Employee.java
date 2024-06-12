package com.example.spring_restfull_jpa_repo_tut.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Step 1: After that Create the Repository layer or JPA repo layer
@Entity
@Data   // We can also use this annotation in place of tostring() ,getter and setter
public class Employee {

    @Id
    @GeneratedValue
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private boolean active;

    public Employee() {
        super();
    }

    public Employee(String name, String lastName, boolean active) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.active = active;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }

}