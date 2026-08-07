package com.thurdass.springboot_lab.mapper.custom;

import com.thurdass.springboot_lab.dto.v1.PersonDTO;
import com.thurdass.springboot_lab.dto.v2.PersonDTOV2;
import com.thurdass.springboot_lab.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTO convertEntityToDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAdress());
        dto.setGender(person.getGender());
        return dto;
    }

    public PersonDTOV2 convertEntityToDTOV2(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(new Date());
        dto.setAddress(person.getAdress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDTOtoEntity(PersonDTO dto) {
        Person entity = new Person();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAdress(dto.getAddress());
        entity.setGender(dto.getGender());
        return entity;
    }

    public Person convertDTOV2toEntity(PersonDTOV2 dto) {
        Person entity = new Person();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAdress(dto.getAddress());
        entity.setGender(dto.getGender());
        return entity;
    }
}
