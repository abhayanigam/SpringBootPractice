package com.example.springbootcallexternalapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class RestSpringBootController {
    @GetMapping("/hello")
//    @RequestMapping("/hello")
    public String hello(){
        return "Hello World Abhaya !";
    }

    @GetMapping("/callHello")
    private String getHello(){
        String url = "http://localhost:8080/hello";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/countries")
    public List<Object> getCountries(){
        String Url = "https://restcountries.eu/rest/v2/all";
        RestTemplate restTemplate = new RestTemplate();
        Object[] countries = restTemplate.getForObject(Url, Object[].class);
        return Arrays.asList(countries);
    }
}

/*
What is a RestTemplate in spring boot?
What is Spring RestTemplate ? According to the official documentation,
RestTemplate is a synchronous client to perform HTTP requests.
It is a higher-order API since it performs HTTP requests by using an HTTP client library like the JDK HttpURLConnection,
 Apache HttpClient, and others.
*/