package com.example.userdetails.controller;

import com.example.userdetails.dao.UserDao;
import com.example.userdetails.service.User;
import com.example.userdetails.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/viewUser")
    public String viewUser(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "view-users";
    }

    @GetMapping("/addUser")
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/addUser")
    public RedirectView addUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/user/addUser", true);
        User savedUser = userService.addUser(user);
        redirectAttributes.addFlashAttribute("savedUser", savedUser);
        redirectAttributes.addFlashAttribute("addUserSuccess", true);
        return redirectView;
    }

//    @DeleteMapping("/deleteUser")
//     void deleteUser(Model model, @PathVariable("id") Integer id, User user) {
//        if (userService.getUsers().contains(user)) {
//            userService.deleteUser(id);
//            model.addAttribute("id", user.getId());
//            model.addAttribute("name", user.getName());
//        }
//    }

//    @DeleteMapping("/deleteUser")
//    public RedirectView deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
//        final RedirectView redirectView = new RedirectView("/user/viewUser", true);
//        User savedUser = userService.deleteUser(id);
//        redirectAttributes.addFlashAttribute("savedUser", savedUser);
//        redirectAttributes.addFlashAttribute("addUserSuccess", true);
//        return redirectView;
//    }

//    @DeleteMapping("/hello/{id}")
//    public String deleteUser(@PathVariable("id") Integer id) {
//        return "Delete by id called";
//    }
}
