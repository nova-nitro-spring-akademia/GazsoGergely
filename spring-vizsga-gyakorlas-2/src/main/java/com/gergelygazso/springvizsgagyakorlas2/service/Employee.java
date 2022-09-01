package com.gergelygazso.springvizsgagyakorlas2.service;

import java.util.Calendar;

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

    public boolean isLastSalaryTwoYearsAgo(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return (currentYear - this.getLastRaiseYear() >= 2);
    }

    public boolean isRaiseDue(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        boolean isRaiseDue = currentYear - this.getLastRaiseYear() >= 5;
        return isRaiseDue;
    }

}
