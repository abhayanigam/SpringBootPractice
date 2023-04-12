package com.learning.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class User {

    private Integer id;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private String email;

    private int age;

}
