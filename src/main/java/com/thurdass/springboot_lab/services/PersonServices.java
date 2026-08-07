package com.thurdass.springboot_lab.services;

import com.thurdass.springboot_lab.exception.ResourceNotFoundException;
import com.thurdass.springboot_lab.dto.PersonRequest;
import com.thurdass.springboot_lab.dto.PersonResponse;
import com.thurdass.springboot_lab.model.Person;
import com.thurdass.springboot_lab.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PersonServices {

    private final PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public PersonServices(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> findAll() {
        logger.info("Finding all People!");
       return repository.findAll().stream().map(this::toResponse).toList();
    }


    @Transactional(readOnly = true)
    public PersonResponse findById(Long id) {
        logger.info("Finding one Person!");
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }


    public PersonResponse create(PersonRequest request) {

        logger.info("Creating one Person!");

        Person person = new Person();
        copyRequestToEntity(request, person);
        return toResponse(repository.save(person));
    }

    public PersonResponse update(Long id, PersonRequest request) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        copyRequestToEntity(request, entity);

        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    private void copyRequestToEntity(PersonRequest request, Person person) {
        person.setFirstName(request.firstName());
        person.setLastName(request.lastName());
        person.setAdress(request.adress());
        person.setGender(request.gender());
    }

    private PersonResponse toResponse(Person person) {
        return new PersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getAdress(),
                person.getGender());
    }
}
