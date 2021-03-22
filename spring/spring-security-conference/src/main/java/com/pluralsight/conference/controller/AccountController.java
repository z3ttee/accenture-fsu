package com.pluralsight.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;


}
