package com.thurdass.springboot_lab.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PersonRequest(
        @NotBlank @Size(max = 70) String firstName,
        @NotBlank @Size(max = 70) String lastName,
        @NotBlank @Size(max = 200) String adress,
        @NotBlank @Size(max = 6) String gender) {
}
