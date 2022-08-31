package com.gergelygazso.springvizsgagyakorlas.domain;

import java.util.Set;

public class Person {

    Long id;

    String name;

    Set<Task> tasks;

    ChooseNextTaskStrategy  nextTaskStrategy;

    public Person() {
    }

    public Person(String name, String strategy) {
        this.name = name;
        setNextTaskStrategy(strategy);
    }

    public Person(Long id, String name, String strategy) {
        this.id = id;
        this.name = name;
        setNextTaskStrategy(strategy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ChooseNextTaskStrategy getNextTaskStrategy() {
        return nextTaskStrategy;
    }

    public void setNextTaskStrategy(String strategy) {
        ChooseNextTaskStrategy nextTaskStrategy;
        if (strategy.equals("DaysLeftStrategy")){
            nextTaskStrategy = new DaysLeftStrategy();
        } else {
            nextTaskStrategy = new PriorityStrategy();
        }
        this.nextTaskStrategy = nextTaskStrategy;
    }


    public Task chooseNextTask(){
        return nextTaskStrategy.chooseNextTask(this.tasks);
    }

}




