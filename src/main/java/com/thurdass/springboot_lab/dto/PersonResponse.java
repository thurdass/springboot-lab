package com.thurdass.springboot_lab.dto;

public record PersonResponse(
        Long id,
        String firstName,
        String lastName,
        String adress,
        String gender) {
}
