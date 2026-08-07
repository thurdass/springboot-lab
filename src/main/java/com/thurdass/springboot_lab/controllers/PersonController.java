package com.thurdass.springboot_lab.controllers;

import com.thurdass.springboot_lab.dto.PersonRequest;
import com.thurdass.springboot_lab.dto.PersonResponse;
import com.thurdass.springboot_lab.dto.v1.PersonDTO;
import com.thurdass.springboot_lab.dto.v2.PersonDTOV2;
import com.thurdass.springboot_lab.services.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonResponse> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonResponse findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findByIdV1(@PathVariable("id") Long id) {
        return service.findByIdV1(id);
    }

    @GetMapping(value = "/v2/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 findByIdV2(@PathVariable("id") Long id) {
        return service.findByIdV2(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PersonResponse> create(@Valid @RequestBody PersonRequest person) {
        return ResponseEntity.status(201).body(service.create(person));
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonResponse update(@PathVariable Long id, @Valid @RequestBody PersonRequest person) {
        return service.update(id, person);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
