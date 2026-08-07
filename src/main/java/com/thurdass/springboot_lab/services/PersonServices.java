package com.thurdass.springboot_lab.services;

import com.github.dozermapper.core.Mapper;
import com.thurdass.springboot_lab.dto.PersonRequest;
import com.thurdass.springboot_lab.dto.PersonResponse;
import com.thurdass.springboot_lab.exception.ResourceNotFoundException;
import com.thurdass.springboot_lab.dto.v1.PersonDTO;
import com.thurdass.springboot_lab.dto.v2.PersonDTOV2;
import com.thurdass.springboot_lab.mapper.custom.PersonMapper;
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
    private final Mapper mapper;
    private final PersonMapper versionMapper;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public PersonServices(PersonRepository repository, Mapper mapper, PersonMapper versionMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.versionMapper = versionMapper;
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> findAll() {
        logger.info("Finding all People!");
       return repository.findAll().stream()
               .map(person -> mapper.map(person, PersonResponse.class))
               .toList();
    }


    @Transactional(readOnly = true)
    public PersonResponse findById(Long id) {
        logger.info("Finding one Person!");
        return repository.findById(id)
                .map(person -> mapper.map(person, PersonResponse.class))
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    @Transactional(readOnly = true)
    public PersonDTO findByIdV1(Long id) {
        logger.info("Finding one Person using API v1!");
        return versionMapper.convertEntityToDTO(findEntityById(id));
    }

    @Transactional(readOnly = true)
    public PersonDTOV2 findByIdV2(Long id) {
        logger.info("Finding one Person using API v2!");
        return versionMapper.convertEntityToDTOV2(findEntityById(id));
    }


    public PersonResponse create(PersonRequest request) {

        logger.info("Creating one Person!");

        Person person = mapper.map(request, Person.class);
        return mapper.map(repository.save(person), PersonResponse.class);
    }

    public PersonResponse update(Long id, PersonRequest request) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        mapper.map(request, entity);

        return mapper.map(repository.save(entity), PersonResponse.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    private Person findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

}
