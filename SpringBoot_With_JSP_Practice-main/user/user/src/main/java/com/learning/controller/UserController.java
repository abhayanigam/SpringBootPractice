package com.learning.controller;

import com.learning.model.User;
import com.learning.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user")
    public String getUser( @ModelAttribute("user") User user){
        log.info("Add new user form");
        return "add-update-user";
    }

    @GetMapping( "user/{userId}")
    public String updateUser(
            @PathVariable("userId") int userId,
            @ModelAttribute("user") User user){

        log.info("Update user form");

        User u = userService.getUser(userId);
        user.setEmail(u.getEmail());
        user.setId(u.getId());
        user.setAge(u.getAge());
        user.setFirstname(u.getFirstname());
        user.setLastname(u.getLastname());


        return "add-update-user";
    }

    @GetMapping("view-users")
    public String getUsers(Model model){

        log.info("User list view");

        model.addAttribute("users", userService.getUsers());


        return "user-list";
    }

    @PostMapping("user")
    public String addUpdateUser(
            @Valid @ModelAttribute("user")  User user,
            BindingResult result){

        if(result.hasErrors()) {
            log.info("There are errors");
            return "add-update-user";
        }
        if(user.getId() != null) {
            userService.updateUser(user);
        }else {
            userService.createUser(user);
        }

        log.info("Add/update user action "+ user.getFirstname());
        return "redirect:/view-users";
    }

    @PostMapping("delete-user/{userId}")
    public String deleteUser(@PathVariable("userId") int userId ){

        log.info("Delete user");

        userService.deleteUser(userId);
        return "redirect:/view-users";
    }


}
