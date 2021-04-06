package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Registration;

import java.util.List;

public interface RegistrationRepository {
    Registration save(Registration registration);
    List<Registration> findAll();
}
