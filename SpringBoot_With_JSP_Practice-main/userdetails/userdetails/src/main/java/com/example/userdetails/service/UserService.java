package com.example.userdetails.service;

import java.util.Collection;

public interface UserService {
    Collection<User> getUsers();
    User addUser(User user);

//    void deleteUser(Integer userId);
}
