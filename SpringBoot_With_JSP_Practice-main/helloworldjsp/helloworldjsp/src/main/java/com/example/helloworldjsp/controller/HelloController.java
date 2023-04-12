package com.example.helloworldjsp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HelloController {
    @GetMapping({
            "/",
            "/hello"
    })
    public String hello(@RequestParam(value = "name", defaultValue = "World",
            required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
