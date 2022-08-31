package com.gergelygazso.springvizsgagyakorlas.service.inmemory;

import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TaskService {

    Set<Task> tasks;

    public Task save(Task task){
        tasks.add(task);
        return task;
    }

    public Task findById(Long id){
        Task task = tasks.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow();
        return task;
    }

    public Set<Task> findAll(){
        return tasks;
    }

    public Task update(Task task){
        Task taskToUpdate = findById(task.getId());
        taskToUpdate = task;
        return taskToUpdate;
    }

    public Task delete(Long id){
        Task taskToDelete = findById(id);
        tasks.remove(taskToDelete);
        return taskToDelete;
    }
}
