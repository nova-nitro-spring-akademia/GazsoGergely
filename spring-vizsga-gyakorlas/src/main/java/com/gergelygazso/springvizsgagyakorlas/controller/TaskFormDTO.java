package com.gergelygazso.springvizsgagyakorlas.controller;

import java.util.Set;

public class TaskFormDTO {

    Long id;

    String name;

    int priority;

    int daysLeft;

    PersonDTO personDTO;

    Long personId;

    Set<PersonDTO> allPersonDTOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public PersonDTO getPersonDTO() {
        return personDTO;
    }

    public void setPersonDTO(PersonDTO personDTO) {
        this.personDTO = personDTO;
    }


    public Set<PersonDTO> getAllPersonDTOs() {
        return allPersonDTOs;
    }

    public void setAllPersonDTOs(Set<PersonDTO> allPersonDTOs) {
        this.allPersonDTOs = allPersonDTOs;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
