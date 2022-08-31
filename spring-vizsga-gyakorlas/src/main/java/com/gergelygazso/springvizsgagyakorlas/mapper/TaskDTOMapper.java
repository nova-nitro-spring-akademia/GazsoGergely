package com.gergelygazso.springvizsgagyakorlas.mapper;

import com.gergelygazso.springvizsgagyakorlas.controller.PersonDTO;
import com.gergelygazso.springvizsgagyakorlas.controller.TaskDTO;
import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDTOMapper {

    public TaskDTO toTaskDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setDaysLeft(task.getDaysLeft());
        taskDTO.setPerson(task.getPerson());
        return taskDTO;
    }

    public Task fromTaskDTO(TaskDTO taskDTO, Person person){
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setPriority(taskDTO.getPriority());
        task.setDaysLeft(taskDTO.getDaysLeft());
        task.setPerson(person);
        return task;
    }

}
