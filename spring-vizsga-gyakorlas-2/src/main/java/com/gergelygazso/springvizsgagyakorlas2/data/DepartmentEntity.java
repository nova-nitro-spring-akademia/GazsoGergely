package com.gergelygazso.springvizsgagyakorlas2.data;

import com.gergelygazso.springvizsgagyakorlas2.service.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

    @OneToMany
    Set<EmployeeEntity> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
