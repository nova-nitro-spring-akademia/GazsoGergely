package com.gergelygazso.springvizsgagyakorlas.domain;

import java.util.Comparator;
import java.util.Set;

public class DaysLeftStrategy implements ChooseNextTaskStrategy{


    @Override
    public Task chooseNextTask(Set<Task> tasks) {
        Task task = tasks.stream().min(Comparator.comparing(Task::getDaysLeft)).get();
        return task;
    }
}
