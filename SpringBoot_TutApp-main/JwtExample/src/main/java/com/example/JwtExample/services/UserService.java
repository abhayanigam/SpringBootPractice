package com.example.JwtExample.services;

import com.example.JwtExample.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    List<User> store = new ArrayList<>();

    public UserService() {
        store.add(new User(UUID.randomUUID().toString(),
                "Abhaya","abc@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),
                "Karan","abc1@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),
                "Nigam","abc2@gmail.com"));
    }

    public List<User> getUser(){
        return this.store;
    }
}
