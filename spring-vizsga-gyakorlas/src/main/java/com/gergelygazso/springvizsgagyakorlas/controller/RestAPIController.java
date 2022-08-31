package com.gergelygazso.springvizsgagyakorlas.controller;

import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import com.gergelygazso.springvizsgagyakorlas.mapper.PersonDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.mapper.PersonWithTasksDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.service.inmemory.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    PersonService personService;

    PersonDTOMapper personDTOMapper;

    PersonWithTasksDTOMapper personWithTasksDTOMapper;

    public RestAPIController(PersonService personService, PersonDTOMapper personDTOMapper, PersonWithTasksDTOMapper personWithTasksDTOMapper) {
        this.personService = personService;
        this.personDTOMapper = personDTOMapper;
        this.personWithTasksDTOMapper = personWithTasksDTOMapper;
    }

    @PostMapping("/persons")
    public PersonDTO savePerson(@RequestBody PersonDTO personDTO){
        Person person = personDTOMapper.fromPersonDTO(personDTO);
        Person savedPerson = personService.save (person);
        return personDTOMapper.toPersonDTO(savedPerson);
    }


    @GetMapping("/persons")
    public Set<PersonWithTasksDTO> findAllPerson(){
        Set<Person> persons = personService.findAll();
        return personWithTasksDTOMapper.fromPersonDTOSet(persons);
    }

}
