package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.SessionJpaRepository;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;

    @Autowired
    private SessionJpaRepository jpaRepository;

    @Test
    public void test() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaNot() {
        List<Session> sessions = jpaRepository.findBySessionLengthNot(30);
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaNotLike() {
        List<Session> sessions = jpaRepository.findBySessionNameNotLike("Java%");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaEndingWith() {
        List<Session> sessions = jpaRepository.findBySessionNameEndingWith("");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaLessThanEqual() {
        List<Session> sessions = jpaRepository.findBySessionLengthLessThanEqual(40);
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaPagingSorting() {
        Page<Session> sessions = jpaRepository.getSessionsWithName("S", PageRequest.of(1, 5, Sort.by(Sort.Direction.DESC, "sessionLength")));
        assertTrue(sessions.getTotalElements() > 0);
    }

    @Test
    public void testCustomImpl() {
        List<Session> sessions = jpaRepository.customGetSessions();
        assertTrue(sessions.size() > 0);
    }

}
