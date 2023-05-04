package com.example.conatainer_tut.javaconfigwithoutxml;

import org.springframework.stereotype.Component;

//@Component("student") --> If we don't want to use this annotation then we use @Bean in config file to do the same to create an object.
public class Example {
    public void run(){
        System.out.println("The method is running");
    }
}
