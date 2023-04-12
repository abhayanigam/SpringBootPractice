package com.example.userdetails.service;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String email;
}
