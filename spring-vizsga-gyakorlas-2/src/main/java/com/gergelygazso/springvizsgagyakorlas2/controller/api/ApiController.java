package com.gergelygazso.springvizsgagyakorlas2.controller.api;

import com.gergelygazso.springvizsgagyakorlas2.controller.EmployeeDTO;
import com.gergelygazso.springvizsgagyakorlas2.controller.mapper.EmployeeDTOMapper;
import com.gergelygazso.springvizsgagyakorlas2.service.Employee;
import com.gergelygazso.springvizsgagyakorlas2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {

    EmployeeService employeeService;

    EmployeeDTOMapper employeeDTOMapper;

    public ApiController(EmployeeService employeeService, EmployeeDTOMapper employeeDTOMapper) {
        this.employeeService = employeeService;
        this.employeeDTOMapper = employeeDTOMapper;
    }

    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){

        Employee savedEntity = employeeService.save(employeeDTOMapper.fromEmployeeDTO(employeeDTO));

        return employeeDTOMapper.toEmployeeDTO(savedEntity);
    }

    @GetMapping("/employees")
    public Set<EmployeeDTO> getAllEmployee(){
        Set<Employee> employeeSet = employeeService.findAll();
        Set<EmployeeDTO> employeeDTOSet = employeeSet.stream().map(employeeDTOMapper::toEmployeeDTO).collect(Collectors.toSet());
        return employeeDTOSet;
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        return employeeDTOMapper.toEmployeeDTO(employee);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.findById(id);
        Employee updatedEmployee = employeeService.update(employeeDTOMapper.fromEmployeeDTO(employeeDTO));
        return employeeDTOMapper.toEmployeeDTO(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public EmployeeDTO deleteEmployee(@PathVariable Long id){
        Employee deletedEmployee = employeeService.deleteById(id);
        return employeeDTOMapper.toEmployeeDTO(deletedEmployee);
    }

    @GetMapping("/employees/neartoretirement")
    public Set<EmployeeDTO> getAllNearToRetirementEmployee(){
        int year = Calendar.getInstance().get(Calendar.YEAR) - 65;
        Set<Employee> allNearToRetirement = employeeService.findByBirthYearLessThan(year);
        Set<EmployeeDTO> employeeDTOSet = allNearToRetirement.stream().map(employeeDTOMapper::toEmployeeDTO).collect(Collectors.toSet());
        return employeeDTOSet;
    }

}
