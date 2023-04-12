package com.example.userdetails.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(value = DuplicateUserException.class)
    public ModelAndView duplicateUserException(DuplicateUserException e) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ref", e.getUser().getId());
        modelAndView.addObject("object", e.getUser());
        modelAndView.addObject("message", "Cannot add an already existing User");
        modelAndView.setViewName("error-user");
        return modelAndView;
    }
}
