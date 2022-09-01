package com.gergelygazso.springvizsgagyakorlas2.service;

import com.gergelygazso.springvizsgagyakorlas2.data.EmployeeEntity;
import com.gergelygazso.springvizsgagyakorlas2.data.EmployeeEntityRepository;
import com.gergelygazso.springvizsgagyakorlas2.data.mapper.EmployeeEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    EmployeeEntityMapper employeeEntityMapper;

    EmployeeEntityRepository employeeEntityRepository;

    public EmployeeService(EmployeeEntityMapper employeeEntityMapper, EmployeeEntityRepository employeeEntityRepository) {
        this.employeeEntityMapper = employeeEntityMapper;
        this.employeeEntityRepository = employeeEntityRepository;
    }

    public Employee save(Employee employee){
        EmployeeEntity savedEmployeeEntity = employeeEntityRepository.save(employeeEntityMapper.toEmployeeEntity(employee));
        return employeeEntityMapper.fromEmployeeEntity(savedEmployeeEntity);
    }

    public Set<Employee> findAll() {
        List<EmployeeEntity> employeeEntityList = employeeEntityRepository.findAll();
        Set<Employee> employeeEntitySet = employeeEntityList.stream().map(employeeEntityMapper::fromEmployeeEntity).collect(Collectors.toSet());
        return employeeEntitySet;
    }

    public Employee findById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findById(id).orElseThrow();
        return employeeEntityMapper.fromEmployeeEntity(employeeEntity);
    }


    public Employee update(Employee employee) {
        return save(employee);
    }

    public Employee deleteById(Long id) {
        Employee employee = findById(id);
        employeeEntityRepository.deleteById(id);
        return employee;
    }

    public Set<Employee> findByBirthYearLessThan(int year) {
        Set<EmployeeEntity> employeeEntitySet = employeeEntityRepository.findByBirthYearLessThan(year);
        Set<Employee> employeeSet = employeeEntitySet.stream().map(employeeEntityMapper::fromEmployeeEntity).collect(Collectors.toSet());
        return employeeSet;
    }
}
