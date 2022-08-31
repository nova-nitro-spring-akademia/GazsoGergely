package com.gergelygazso.springvizsgagyakorlas.domain;

import java.util.Set;

public interface ChooseNextTaskStrategy {

    Task chooseNextTask(Set<Task> tasks);

}
