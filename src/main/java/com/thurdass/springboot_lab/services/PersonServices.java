package com.thurdass.springboot_lab.services;


import com.thurdass.springboot_lab.exception.ResourceNotFoundException;
import com.thurdass.springboot_lab.model.Person;
import com.thurdass.springboot_lab.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all People!");
       return repository.findAll();
    }


    public Person findById(Long id) {
        logger.info("Finding one Person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirtsName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAdress("Some Address in Brasil");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirtsName(person.getFirtsName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
