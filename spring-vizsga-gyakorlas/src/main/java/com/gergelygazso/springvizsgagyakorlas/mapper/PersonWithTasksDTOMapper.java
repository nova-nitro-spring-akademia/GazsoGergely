package com.gergelygazso.springvizsgagyakorlas.mapper;

import com.gergelygazso.springvizsgagyakorlas.controller.PersonDTO;
import com.gergelygazso.springvizsgagyakorlas.controller.PersonWithTasksDTO;
import com.gergelygazso.springvizsgagyakorlas.controller.TaskDTO;
import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PersonWithTasksDTOMapper {

    TaskDTOMapper taskDTOMapper;

    public PersonWithTasksDTOMapper(TaskDTOMapper taskDTOMapper) {
        this.taskDTOMapper = taskDTOMapper;
    }

    public PersonWithTasksDTO toPersonWithTasksDTO(Person person){
        PersonWithTasksDTO personWithTasksDTO = new PersonWithTasksDTO();
        personWithTasksDTO.setId(person.getId());
        personWithTasksDTO.setName(person.getName());
        personWithTasksDTO.setNextTaskStrategy(person.getNextTaskStrategy().getClass().getSimpleName());
        Set<TaskDTO> taskDTOSet = person.getTasks().stream().map(taskDTOMapper::toTaskDTO).collect(Collectors.toSet());
        personWithTasksDTO.setTasks(taskDTOSet);
        return personWithTasksDTO;
    }

    public Person fromPersonDTO(PersonWithTasksDTO personWithTasksDTO){
        Person person = new Person();
        person.setId(personWithTasksDTO.getId());
        person.setName(personWithTasksDTO.getName());
        person.setNextTaskStrategy(personWithTasksDTO.getNextTaskStrategy());
        person.setTasks(personWithTasksDTO.getTasks().stream().map(taskDTOMapper::fromTaskDTO).collect(Collectors.toSet()));
        return person;
    }

    public Set<PersonWithTasksDTO> fromPersonDTOSet(Set<Person> persons) {
        return persons.stream()
                .map(this::toPersonWithTasksDTO)
                .collect(Collectors.toSet());
    }
}
