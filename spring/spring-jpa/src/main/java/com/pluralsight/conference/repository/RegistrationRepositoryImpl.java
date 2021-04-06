package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Registration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Registration save(Registration registration) {
        entityManager.persist(registration);
        return registration;
    }

    @Override
    public List<Registration> findAll() {
        List<Registration> registrations = entityManager.createQuery("select r from Registration r").getResultList();

        return registrations;
    }
}
