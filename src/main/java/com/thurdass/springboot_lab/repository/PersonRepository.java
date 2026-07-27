package com.thurdass.springboot_lab.repository;

import com.thurdass.springboot_lab.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
