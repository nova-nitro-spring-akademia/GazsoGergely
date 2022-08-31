package com.gergelygazso.springvizsgagyakorlas.mapper;

import com.gergelygazso.springvizsgagyakorlas.controller.PersonDTO;
import com.gergelygazso.springvizsgagyakorlas.domain.Person;

public class PersonDTOMapper {

    public PersonDTO toPersonDTO(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(personDTO.getName());
        personDTO.setNextTaskStrategy(personDTO.getNextTaskStrategy());
        return personDTO;
    }

    public Person fromPersonDTO(PersonDTO personDTO){
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setNextTaskStrategy(personDTO.getNextTaskStrategy());
        return person;
    }

}
