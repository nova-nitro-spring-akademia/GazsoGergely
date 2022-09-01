package com.gergelygazso.springvizsgagyakorlas2.data.mapper;

import com.gergelygazso.springvizsgagyakorlas2.data.EmployeeEntity;
import com.gergelygazso.springvizsgagyakorlas2.service.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityMapper {
    Long id;

    String name;

    int birthYear;

    int startYear;

    int lastRaiseYear;

    int salary;

    public EmployeeEntity toEmployeeEntity(Employee employee){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setName(employee.getName());
        employeeEntity.setBirthYear(employee.getBirthYear());
        employeeEntity.setStartYear(employee.getStartYear());
        employeeEntity.setLastRaiseYear(employee.getLastRaiseYear());
        employeeEntity.setSalary(employee.getSalary());
        return employeeEntity;
    }

    public Employee fromEmployeeEntity(EmployeeEntity employeeEntity){
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setName(employeeEntity.getName());
        employee.setBirthYear(employeeEntity.getBirthYear());
        employee.setStartYear(employeeEntity.getStartYear());
        employee.setLastRaiseYear(employeeEntity.getLastRaiseYear());
        employee.setSalary(employeeEntity.getSalary());
        return employee;
    }

}
