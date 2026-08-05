package com.thurdass.springboot_lab.services;

import com.thurdass.springboot_lab.exception.ResourceNotFoundException;
import com.thurdass.springboot_lab.model.Person;
import com.thurdass.springboot_lab.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all People!");
       return repository.findAll();
    }


    public Person findById(Long id) {
        logger.info("Finding one Person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }


    public Person create(Person person) {

        logger.info("Creating one Person!");

        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
