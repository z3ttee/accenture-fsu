package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TimeSlotJpaRepository extends JpaRepository<TimeSlot, Long> {

    // Method: Before
    // Also: After, Between
    List<TimeSlot> findBySlotDateBefore(Date beforeDate);

    // Method: True
    // Also: False
    // Checks for boolean values
    List<TimeSlot> findByIsKeynoteTrue();

}
