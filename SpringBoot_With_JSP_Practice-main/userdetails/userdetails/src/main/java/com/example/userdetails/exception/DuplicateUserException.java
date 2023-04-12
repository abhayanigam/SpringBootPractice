package com.example.userdetails.exception;

import com.example.userdetails.service.User;
import lombok.Getter;

@Getter
public class DuplicateUserException extends RuntimeException {
    private final User user;

    public DuplicateUserException(User user) {
        this.user = user;
    }
}
