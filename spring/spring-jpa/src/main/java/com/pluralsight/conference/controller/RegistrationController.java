package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import com.pluralsight.conference.service.RegistrationService;
import com.pluralsight.conference.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute ("registration")Registration registration) {
        return "registration";
    }

    @GetMapping("registrations")
    public @ResponseBody List<Registration> getRegistrations(@ModelAttribute ("registration")Registration registration) {
        List<Registration> registrations = service.findAll();
        return registrations;
    }

    @GetMapping("registration-reports")
    public @ResponseBody List<RegistrationReport> getRegistrationReportss(@ModelAttribute ("registration")Registration registration) {
        List<RegistrationReport> registrationReports = service.findAllReports();
        return registrationReports;
    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")
                                              Registration registration,
                                  BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "registration";
        }

        System.out.println("Registration: " + registration.getName());
        service.addRegistration(registration);

        return "redirect:registration";
    }

}
