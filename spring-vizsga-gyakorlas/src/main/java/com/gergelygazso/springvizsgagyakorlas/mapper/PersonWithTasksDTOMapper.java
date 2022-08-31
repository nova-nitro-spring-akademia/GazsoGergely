package com.gergelygazso.springvizsgagyakorlas.mapper;

import com.gergelygazso.springvizsgagyakorlas.controller.PersonDTO;
import com.gergelygazso.springvizsgagyakorlas.controller.PersonWithTasksDTO;
import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PersonWithTasksDTOMapper {

    public PersonWithTasksDTO toPersonWithTasksDTO(Person person){
        PersonWithTasksDTO personWithTasksDTO = new PersonWithTasksDTO();
        personWithTasksDTO.setId(person.getId());
        personWithTasksDTO.setName(person.getName());
        personWithTasksDTO.setNextTaskStrategy(person.getNextTaskStrategy().getClass().getSimpleName());
        personWithTasksDTO.setTasks(person.getTasks());
        return personWithTasksDTO;
    }

    public Person fromPersonDTO(PersonWithTasksDTO personWithTasksDTO){
        Person person = new Person();
        person.setId(personWithTasksDTO.getId());
        person.setName(personWithTasksDTO.getName());
        person.setNextTaskStrategy(personWithTasksDTO.getNextTaskStrategy());
        person.setTasks(personWithTasksDTO.getTasks());
        return person;
    }

    public Set<PersonWithTasksDTO> fromPersonDTOSet(Set<Person> persons) {
        return persons.stream()
                .map(this::toPersonWithTasksDTO)
                .collect(Collectors.toSet());
    }
}
