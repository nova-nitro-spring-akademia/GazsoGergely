package com.gergelygazso.springvizsgagyakorlas2.controller.mapper;

import com.gergelygazso.springvizsgagyakorlas2.controller.DepartmentFormView;
import com.gergelygazso.springvizsgagyakorlas2.service.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentFormViewMapper {

    public DepartmentFormView toDepartmentFormView(Department department){
        DepartmentFormView departmentFormView = new DepartmentFormView();
        departmentFormView.setId(department.getId());
        departmentFormView.setName(department.getName());
        departmentFormView.setEmployees(department.getEmployees());
        return departmentFormView;
    }

    public Department fromDepartmentFormView(DepartmentFormView departmentFormView){
        Department department = new Department();
        department.setId(departmentFormView.getId());
        department.setName(departmentFormView.getName());
        department.setEmployees(departmentFormView.getEmployees());
        return department;
    }

}
