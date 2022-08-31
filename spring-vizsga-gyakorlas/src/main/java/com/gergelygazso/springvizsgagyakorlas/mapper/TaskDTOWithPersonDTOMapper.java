package com.gergelygazso.springvizsgagyakorlas.mapper;

import com.gergelygazso.springvizsgagyakorlas.controller.TaskDTO;
import com.gergelygazso.springvizsgagyakorlas.controller.TaskDTOWithPersonDTO;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TaskDTOWithPersonDTOMapper {

    PersonDTOMapper personDTOMapper;

    public TaskDTOWithPersonDTOMapper(PersonDTOMapper personDTOMapper) {
        this.personDTOMapper = personDTOMapper;
    }

    public TaskDTOWithPersonDTO toTaskDTOWithPersonDTO(Task task){
        TaskDTOWithPersonDTO taskDTOWithPersonDTO = new TaskDTOWithPersonDTO();
        taskDTOWithPersonDTO.setId(task.getId());
        taskDTOWithPersonDTO.setName(task.getName());
        taskDTOWithPersonDTO.setPriority(task.getPriority());
        taskDTOWithPersonDTO.setDaysLeft(task.getDaysLeft());
        taskDTOWithPersonDTO.setPersonDTO(personDTOMapper.toPersonDTO(task.getPerson()));
        return taskDTOWithPersonDTO;
    }


    public Set<TaskDTOWithPersonDTO> toTaskDTOWithPersonDTOSet(Set<Task> tasks) {
        return tasks.stream()
                .map(this::toTaskDTOWithPersonDTO)
                .collect(Collectors.toSet());
    }

}
