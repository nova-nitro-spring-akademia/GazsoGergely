package com.gergelygazso.springvizsgagyakorlas.mapper;

import com.gergelygazso.springvizsgagyakorlas.controller.PersonDTO;
import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PersonDTOMapper {

    public PersonDTO toPersonDTO(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setNextTaskStrategy(person.getNextTaskStrategy().getClass().getSimpleName());
        return personDTO;
    }

    public Person fromPersonDTO(PersonDTO personDTO){
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setNextTaskStrategy(personDTO.getNextTaskStrategy());
        return person;
    }

    public Set<PersonDTO> toPersonDTOSet(Set<Person> persons){
        return persons.stream().map(this::toPersonDTO).collect(Collectors.toSet());
    }

}
