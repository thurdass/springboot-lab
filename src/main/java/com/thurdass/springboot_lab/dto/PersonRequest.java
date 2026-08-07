package com.thurdass.springboot_lab.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PersonRequest {

    @NotBlank
    @Size(max = 70)
    private String firstName;

    @NotBlank
    @Size(max = 70)
    private String lastName;

    @NotBlank
    @Size(max = 200)
    private String adress;

    @NotBlank
    @Size(max = 6)
    private String gender;

    public PersonRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
