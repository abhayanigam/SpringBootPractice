package com.example.thymeleaf_example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

//@Controller
/**
 * Thymeleaf is a server-side templating engine that is typically used for server-side rendering of HTML templates.
 * It is commonly used with the **`@Controller`** annotation,
 * where the controller methods return the name of the Thymeleaf template to be rendered,
 * and the template engine processes the template and generates the HTML response.
 * Since **`@RestController`** is specifically meant for building RESTful APIs and not for server-side rendering
 * of HTML templates, it doesn't work in conjunction with Thymeleaf.
 */
public class ExampleController {
    @GetMapping("/")
    public String example(Model model) {
        model.addAttribute("name", "Abhaya Nigam 😎");
        model.addAttribute("items", new String[]{"Item 1", "Item 2", "Item 3"});
        System.out.println("Running");
        return "example-template";
        // Now go to the example-template.html
    }
}
