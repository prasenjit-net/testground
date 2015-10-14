package com.example.repository;

import com.example.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by PRASENJIT on 10/15/2015.
 */
public interface PersonRepository extends JpaRepository<Person, String> {
}
