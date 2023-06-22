package com.example.MVCFundamental.controller;

import com.example.MVCFundamental.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("registration") Registration registration) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")Registration registration, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("There is an Error");
            return "registration";
        }
        System.out.println("Registration: " + registration.getName());
        return "redirect:registration";
        // To redirect the page again use "redirect:"
    }

}
