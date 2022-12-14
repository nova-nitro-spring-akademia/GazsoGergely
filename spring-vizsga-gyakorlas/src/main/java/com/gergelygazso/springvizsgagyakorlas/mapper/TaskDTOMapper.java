package com.gergelygazso.springvizsgagyakorlas.mapper;

import com.gergelygazso.springvizsgagyakorlas.controller.PersonDTO;
import com.gergelygazso.springvizsgagyakorlas.controller.TaskDTO;
import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TaskDTOMapper {


    public TaskDTO toTaskDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setDaysLeft(task.getDaysLeft());
        taskDTO.setPersonId(task.getPerson().getId());
        return taskDTO;
    }

    public Task fromTaskDTO(TaskDTO taskDTO){
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setPriority(taskDTO.getPriority());
        task.setDaysLeft(taskDTO.getDaysLeft());
        return task;
    }

    public Set<TaskDTO> toTaskDTOSet(Set<Task> tasks) {
        return tasks.stream()
                .map(this::toTaskDTO)
                .collect(Collectors.toSet());
    }

}
