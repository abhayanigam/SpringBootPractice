package com.example.Logging_example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @RequestMapping("/")
    public String home(){
//        logger.error("Error info");

//        logger.trace("Home Method accessed");  // --  for log levels
        logger.info("This is the error");
        System.out.println("Hello to this program");
        logger.info("Exiting");
        return "Hello Spring Page";
    }
}
