package com.gergelygazso.springvizsgagyakorlas2.controller;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EmployeeDTO {

    Long id;

    @NotBlank
    String name;

    @Min(value = 0, message = "birth year be greater than 0")
    int birthYear;

    @Min(value = 0, message = "start year be greater than 0")
    int startYear;

    int lastRaiseYear;

    @Min(value = 0, message = "salary be greater than 0")
    int salary;

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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getLastRaiseYear() {
        return lastRaiseYear;
    }

    public void setLastRaiseYear(int lastRaiseYear) {
        this.lastRaiseYear = lastRaiseYear;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
