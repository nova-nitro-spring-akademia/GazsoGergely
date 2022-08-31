package com.gergelygazso.springvizsgagyakorlas.mapper;

import com.gergelygazso.springvizsgagyakorlas.controller.TaskFormDTO;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskFormDTOMapper {

    PersonDTOMapper personDTOMapper;

    public TaskFormDTOMapper(PersonDTOMapper personDTOMapper) {
        this.personDTOMapper = personDTOMapper;
    }

    public Task fromTaskFormDTO(TaskFormDTO taskFormDTO){
        Task task = new Task();
        task.setId(taskFormDTO.getId());
        task.setName(taskFormDTO.getName());
        task.setPriority(taskFormDTO.getPriority());
        task.setDaysLeft(taskFormDTO.getDaysLeft());
        task.setPerson(personDTOMapper.fromPersonDTO(taskFormDTO.getPersonDTO()));
        return task;
    }

}
