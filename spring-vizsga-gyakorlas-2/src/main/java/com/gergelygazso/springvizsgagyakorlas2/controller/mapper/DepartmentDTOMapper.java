package com.gergelygazso.springvizsgagyakorlas2.controller.mapper;

import com.gergelygazso.springvizsgagyakorlas2.controller.DepartmentDTO;
import com.gergelygazso.springvizsgagyakorlas2.data.DepartmentEntity;
import com.gergelygazso.springvizsgagyakorlas2.service.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DepartmentDTOMapper {

    public DepartmentDTO toDepartmenDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        departmentDTO.setEmployees(department.getEmployees());
        return departmentDTO;
    }

    public Department fromDepartmenDTO(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setEmployees(departmentDTO.getEmployees());
        return department;
    }

    public Set<Department> fromDepartmentDTOSet(Set<DepartmentDTO> departmentDTOSet){
        return departmentDTOSet.stream().map(this::fromDepartmenDTO).collect(Collectors.toSet());
    }

    public Set<DepartmentDTO> toDepartmentDTOSet(Set<Department> departmentSet){
        return departmentSet.stream().map(this::toDepartmenDTO).collect(Collectors.toSet());
    }

}
