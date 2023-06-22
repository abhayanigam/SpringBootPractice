package com.example.MVCFundamental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
