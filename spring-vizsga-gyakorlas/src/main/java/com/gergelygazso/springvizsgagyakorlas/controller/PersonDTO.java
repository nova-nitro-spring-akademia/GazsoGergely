package com.gergelygazso.springvizsgagyakorlas.controller;

import com.gergelygazso.springvizsgagyakorlas.domain.ChooseNextTaskStrategy;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;

import java.util.Set;

public class PersonDTO {

    Long id;

    String name;

    String nextTaskStrategy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNextTaskStrategy() {
        return nextTaskStrategy;
    }

    public void setNextTaskStrategy(String nextTaskStrategy) {
        this.nextTaskStrategy = nextTaskStrategy;
    }
}
