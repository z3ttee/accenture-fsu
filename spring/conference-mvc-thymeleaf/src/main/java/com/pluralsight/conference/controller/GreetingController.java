package com.pluralsight.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("greeting")
    public String greeting(Map<String, Object> model) {
        model.put("message", "Hello sir! This is a greeting!");

        // This creates the reference to the .jsp file (greeting.jsp)
        return "greeting";
    }

    @GetMapping("thyme")
    public String thyme(Map<String, Object> model) {
        model.put("message", "Hello thymeleaf! This is a greeting!");

        // This creates the reference to the .html file (thyme.html)
        return "thyme";
    }

}
