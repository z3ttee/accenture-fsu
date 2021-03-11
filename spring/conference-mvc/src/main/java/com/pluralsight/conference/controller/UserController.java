package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(
            @RequestParam(value = "firstname", defaultValue = "Cedric") String firstname,
            @RequestParam(value = "lastname", defaultValue = "Zitzmann") String lastname,
            @RequestParam(value = "age", defaultValue = "19") int age
    ) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user")
    public User create(User user) {
        System.out.println(user.getFirstname());

        return user;
    }

}
