package com.example.userdetails.dao;

import java.util.Collection;
import java.util.Optional;

public interface UserDao {
    Collection<UserData> findAll();

    Optional<UserData> findById(Integer id);

    UserData add(UserData user);

//    public void deleteUser(Integer userId);
}
