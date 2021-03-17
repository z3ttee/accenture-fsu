package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerJpaRepository extends JpaRepository<Speaker, Long> {

    // Query method: AND
    List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);

    // Query method: OR
    List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);

    // Method: Null
    // Also possible: IsNull, NotNull, IsNotNull
    List<Speaker> findBySpeakerPhotoNull();

    // Method: In
    // Also possible: NotIn
    List<Speaker> findByCompanyIn(List<String> companies);

    // Method: IgnoreCase
    List<Speaker> findByCompanyIgnoreCase(String company);

    // Method: OrderBy
    List<Speaker> findByFirstNameOrderByFirstName(String firstName);


    // Method: Top(n)
    // Also: First, Distinct
    List<Speaker> findTop5ByFirstName(String firstName);

}
