package com.gergelygazso.springvizsgagyakorlas2.controller;

import com.gergelygazso.springvizsgagyakorlas2.data.EmployeeEntity;

import java.util.Set;

public class DepartmentDTO {

    Long id;

    String name;

    Set<EmployeeEntity> employees;

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

    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
