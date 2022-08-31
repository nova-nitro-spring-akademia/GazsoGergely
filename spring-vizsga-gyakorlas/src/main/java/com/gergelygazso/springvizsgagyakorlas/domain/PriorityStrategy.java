package com.gergelygazso.springvizsgagyakorlas.domain;

import java.util.Comparator;
import java.util.Set;

public class PriorityStrategy implements  ChooseNextTaskStrategy{

    @Override
    public Task chooseNextTask(Set<Task> tasks) {
        Task task = tasks.stream().max(Comparator.comparing(Task::getPriority)).get();
        return task;
    }
}
