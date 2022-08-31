package com.gergelygazso.springvizsgagyakorlas;

import com.gergelygazso.springvizsgagyakorlas.domain.DaysLeftStrategy;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringVizsgaGyakorlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringVizsgaGyakorlasApplication.class, args);

//		Task task1 = new Task();
//		task1.setDaysLeft(2);
//		task1.setName("task1");
//		Task task2 = new Task();
//		task2.setDaysLeft(10);
//		task2.setName("task2");
//		Task task3 = new Task();
//		task3.setDaysLeft(99);
//		task3.setName("task3");
//		Set<Task> tasks = Set.of(task1, task2, task3);
//
//		DaysLeftStrategy daysLeftStrategy = new DaysLeftStrategy();
//
//		Task nextTask = daysLeftStrategy.chooseNextTask(tasks);
//
//		System.out.println("min task: " + nextTask.getName());

	}

}
