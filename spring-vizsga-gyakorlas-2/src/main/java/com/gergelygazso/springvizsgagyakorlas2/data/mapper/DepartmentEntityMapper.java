package com.gergelygazso.springvizsgagyakorlas2.data.mapper;

import com.gergelygazso.springvizsgagyakorlas2.data.DepartmentEntity;
import com.gergelygazso.springvizsgagyakorlas2.service.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DepartmentEntityMapper {

    public DepartmentEntity toDepartmentEntity(Department department){
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(department.getId());
        departmentEntity.setName(department.getName());
        departmentEntity.setEmployees(department.getEmployees());
        return departmentEntity;
    }

    public Department fromDepartmentEntity(DepartmentEntity departmentEntity){
        Department department = new Department();
        department.setId(departmentEntity.getId());
        department.setName(departmentEntity.getName());
        department.setEmployees(departmentEntity.getEmployees());
        return department;
    }

    public Set<Department> fromDepartmentEntitySet(List<DepartmentEntity> departmentEntitySet){
        return departmentEntitySet.stream().map(this::fromDepartmentEntity).collect(Collectors.toSet());
    }

}
