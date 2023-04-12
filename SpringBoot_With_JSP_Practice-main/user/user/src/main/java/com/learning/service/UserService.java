package com.learning.service;


import com.learning.model.User;

import java.util.List;

public interface UserService {

    User getUser(Integer userId);

    void deleteUser(Integer userId);

    void updateUser(User user);

    Integer createUser(User user);

    List<User> getUsers();
}
