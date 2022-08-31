package com.gergelygazso.springvizsgagyakorlas.controller;

import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import com.gergelygazso.springvizsgagyakorlas.mapper.PersonDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.service.inmemory.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/api")
public class RestController {

    PersonService personService;

    PersonDTOMapper personDTOMapper;

    public RestController(PersonService personService, PersonDTOMapper personDTOMapper) {
        this.personService = personService;
        this.personDTOMapper = personDTOMapper;
    }

    @PostMapping("/persons")
    public PersonDTO savePerson(@RequestBody PersonDTO personDTO){
        Person person = personDTOMapper.fromPersonDTO(personDTO);
        Person savedPerson = personService.save(person);
        return personDTOMapper.toPersonDTO(savedPerson);
    }


    @GetMapping("/persons")
    public Set<PersonWithTasksDTO> findAllPerson(){

    }

}
