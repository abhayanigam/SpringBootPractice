package com.example.userdetails.dao;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

    private final Map<Integer, UserData> storedUsers;

    public UserDaoImpl(Map<Integer, UserData> storedUsers) {
        this.storedUsers = storedUsers;
    }

    @Override
    public Collection<UserData> findAll() {
        if (storedUsers.isEmpty()) {
            return Collections.emptyList();
        }
        return storedUsers.values();
    }

    @Override
    public Optional<UserData> findById(Integer id) {
        return Optional.ofNullable(storedUsers.get(id));
    }

    @Override
    public UserData add(UserData user) {
        storedUsers.put(user.getId(), user);
        return user;
    }
}
