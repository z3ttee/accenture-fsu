package me.zitzmanncedric.conferencedemo.repositories;

import me.zitzmanncedric.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {



}
