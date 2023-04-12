package com.learning.service;


import com.learning.model.User;
import com.learning.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer userId) {
        User user = userRepository.getUser(userId);
        return user;
    }

    public void deleteUser(Integer userId) {

        userRepository.deleteUser(userId);
    }

    public void updateUser(User user) {

        userRepository.updateUser(user);
        return;
    }

    public Integer createUser(User user) {
        Integer userId = userRepository.createUser(user);
        return userId;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
