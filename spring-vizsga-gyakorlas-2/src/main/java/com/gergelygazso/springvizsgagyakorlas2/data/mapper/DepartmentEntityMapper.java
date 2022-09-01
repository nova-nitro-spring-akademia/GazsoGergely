package com.gergelygazso.springvizsgagyakorlas2.data.mapper;

import com.gergelygazso.springvizsgagyakorlas2.data.DepartmentEntity;
import com.gergelygazso.springvizsgagyakorlas2.service.Department;
import org.springframework.stereotype.Component;

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

}
