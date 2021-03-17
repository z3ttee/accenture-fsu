package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepository {

    @Autowired
    private SessionJpaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public Session create(Session session) {
        entityManager.persist(session);
        entityManager.flush();
        return session;
    }

    public Session update(Session session) {
        return repository.saveAndFlush(session);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Session find(Long id) {
        return repository.getOne(id);
    }

    public List<Session> list() {
        return repository.findAll();
    }

    public List<Session> getSessionsThatHaveName(String name) {
        return repository.findBySessionNameContains(name);
    }
}
