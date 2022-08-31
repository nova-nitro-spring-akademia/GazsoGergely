package com.gergelygazso.springvizsgagyakorlas.controller;

import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import com.gergelygazso.springvizsgagyakorlas.mapper.PersonDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.mapper.PersonWithTasksDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.mapper.TaskDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.mapper.TaskDTOWithPersonDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.service.inmemory.PersonService;
import com.gergelygazso.springvizsgagyakorlas.service.inmemory.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    PersonService personService;

    PersonDTOMapper personDTOMapper;

    PersonWithTasksDTOMapper personWithTasksDTOMapper;

    TaskDTOMapper taskDTOMapper;

    TaskService taskService;

    TaskDTOWithPersonDTOMapper taskDTOWithPersonDTOMapper;

    public RestAPIController(PersonService personService, PersonDTOMapper personDTOMapper, PersonWithTasksDTOMapper personWithTasksDTOMapper, TaskDTOMapper taskDTOMapper, TaskService taskService, TaskDTOWithPersonDTOMapper taskDTOWithPersonDTOMapper) {
        this.personService = personService;
        this.personDTOMapper = personDTOMapper;
        this.personWithTasksDTOMapper = personWithTasksDTOMapper;
        this.taskDTOMapper = taskDTOMapper;
        this.taskService = taskService;
        this.taskDTOWithPersonDTOMapper = taskDTOWithPersonDTOMapper;
    }

    @PostMapping("/persons")
    public PersonDTO savePerson(@RequestBody PersonDTO personDTO){
        Person person = personDTOMapper.fromPersonDTO(personDTO);
        Person savedPerson = personService.save(person);
        return personDTOMapper.toPersonDTO(savedPerson);
    }


    @GetMapping("/persons")
    public Set<PersonWithTasksDTO> findAllPerson(){
        Set<Person> persons = personService.findAll();
        return personWithTasksDTOMapper.fromPersonDTOSet(persons);
    }

    @PostMapping("/tasks")
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO){

        if(taskDTO.getPersonId()==null){
            throw new IllegalArgumentException("Person id can't be null!!!");
        }
        //saving task
        Task task = taskDTOMapper.fromTaskDTO(taskDTO);
        Person person = personService.findById(taskDTO.getPersonId());
        task.setPerson(person);
        TaskDTO savedTaskDTO = taskDTOMapper.toTaskDTO(taskService.save(task));

        return savedTaskDTO;
    }

    @GetMapping("/tasks")
    public Set<TaskDTOWithPersonDTO> findAllTask(){
        Set<TaskDTOWithPersonDTO> taskDTOWithPersonDTOSet =
                taskDTOWithPersonDTOMapper.toTaskDTOWithPersonDTOSet(taskService.findAll());
        return taskDTOWithPersonDTOSet;
    }



}
