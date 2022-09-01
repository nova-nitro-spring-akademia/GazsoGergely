package com.gergelygazso.springvizsgagyakorlas2.service;

import com.gergelygazso.springvizsgagyakorlas2.data.EmployeeEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


public class Department {

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

    public void assignEmployee(EmployeeEntity employeeEntity){
        if (employees==null){
            employees = new HashSet<EmployeeEntity>();
            employees.add(employeeEntity);
        }else{
            employees.add(employeeEntity);
        }
    }
}
