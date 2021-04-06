package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Registration;

import javax.transaction.Transactional;
import java.util.List;

public interface RegistrationService {
    @Transactional
    Registration addRegistration(Registration registration);
    List<Registration> findAll();
}
