package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionJpaRepository extends JpaRepository<Session, Long>, SessionCustomJpaRepository {

    // Method name: findBy + propertyName + Rule
    // = Query DSL (domain specific language)
    //
    // This would result in following JPQL query:
    // select s from Session s where s.sessionName like :name
    List<Session> findBySessionNameContains(String name);
    // Result in SQL: select * from Session s where s.session_name like :name

    // The example above has an array of entries, but if only one is needed, there are return types to define:
    // findFirstBy...
    // countBy...


    // Method: Not
    // Also possible: Is, Equals
    List<Session> findBySessionLengthNot(Integer sessionLength);

    // Method: LessThanEqual
    // Also possible: LessThan, GreaterThan, GreatherThanEqual
    List<Session> findBySessionLengthLessThanEqual(Integer sessionLength);


    // Method: NotLike
    // Also possible: Like
    List<Session> findBySessionNameNotLike(String needle);


    // Method: StartingWith
    // Also possible: EndingWith, Containing
    List<Session> findBySessionNameEndingWith(String ending);

    @Query("select s from Session s where s.sessionName like %:name")
    Page<Session> getSessionsWithName(@Param("name") String name, Pageable pageable);

}
