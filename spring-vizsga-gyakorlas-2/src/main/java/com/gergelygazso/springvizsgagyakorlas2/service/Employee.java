package com.gergelygazso.springvizsgagyakorlas2.service;

public class Employee {

    Long id;

    String name;

    int birthYear;

    int startYear;

    int lastRaiseYear;

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
