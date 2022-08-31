package com.gergelygazso.springvizsgagyakorlas.service.inmemory;

import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TaskService {

    Set<Task> tasks;

    public Task save(Task task){
        if (tasks==null){
            tasks=new HashSet<Task>();
            tasks.add(task);
        }else{
            tasks.add(task);
        }
        //a Person Task listájába is mentsük el a Task-ot
        task.getPerson().addTask(task);
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
