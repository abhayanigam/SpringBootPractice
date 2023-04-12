package com.learning.resource;

import com.learning.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserResource {

    @GetMapping("/user")
        public User getUser(@RequestParam(value = "firstname", defaultValue = "Bryan") String firstname,
                        @RequestParam(value = "lastname", defaultValue = "Hansen") String lastname,
                        @RequestParam(value = "age", defaultValue = "43") int age) {
        User user = new User();

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user")
    public User postUser(User user) {
        System.out.println("User firstname:" + user.getFirstname());

        return user;
    }

}
