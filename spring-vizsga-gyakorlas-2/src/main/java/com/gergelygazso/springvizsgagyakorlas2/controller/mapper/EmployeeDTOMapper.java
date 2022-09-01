package com.gergelygazso.springvizsgagyakorlas2.controller.mapper;

import com.gergelygazso.springvizsgagyakorlas2.controller.EmployeeDTO;
import com.gergelygazso.springvizsgagyakorlas2.data.EmployeeEntity;
import com.gergelygazso.springvizsgagyakorlas2.service.Employee;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmployeeDTOMapper {
    Long id;

    String name;

    int birthYear;

    int startYear;

    int lastRaiseYear;

    int salary;

    public EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setBirthYear(employee.getBirthYear());
        employeeDTO.setStartYear(employee.getStartYear());
        employeeDTO.setLastRaiseYear(employee.getLastRaiseYear());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    public Employee fromEmployeeDTO(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setBirthYear(employeeDTO.getBirthYear());
        employee.setStartYear(employeeDTO.getStartYear());
        employee.setLastRaiseYear(employeeDTO.getLastRaiseYear());
        employee.setSalary(employeeDTO.getSalary());
        return employee;
    }

    public Set<EmployeeDTO> toEmployeeDTOSet(Set<Employee> employeeSet){
        return employeeSet.stream().map(this::toEmployeeDTO).collect(Collectors.toSet());
    }

}
