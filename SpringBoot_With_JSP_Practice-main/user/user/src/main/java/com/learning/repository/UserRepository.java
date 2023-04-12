package com.learning.repository;

import com.learning.model.User;


import java.lang.Integer;
import java.util.List;


public interface UserRepository {

    User getUser(Integer userId);

    void deleteUser(Integer userId);

    void updateUser(User user);

    Integer createUser(User user);

    List<User> getUsers();

}
