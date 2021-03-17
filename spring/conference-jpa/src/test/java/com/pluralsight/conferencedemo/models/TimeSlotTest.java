package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.TimeSlotJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TimeSlotTest {

    @Autowired
    private TimeSlotJpaRepository jpaRepository;


    @Test
    public void testJpaBefore() {
        List<TimeSlot> slots = jpaRepository.findBySlotDateBefore(new Date());

        for(TimeSlot slot : slots) {
            System.out.println(slot.getSlotId());
        }

        Assertions.assertTrue(slots.size() > 0);
    }

    @Test
    public void testJpaTrue() {
        List<TimeSlot> slots = jpaRepository.findByIsKeynoteTrue();

        for(TimeSlot slot : slots) {
            System.out.println(slot.getSlotId());
        }

        Assertions.assertTrue(slots.size() > 0);
    }

}
