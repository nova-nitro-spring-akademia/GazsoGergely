package com.gergelygazso.springvizsgagyakorlas2.service;

import com.gergelygazso.springvizsgagyakorlas2.data.DepartmentEntity;
import com.gergelygazso.springvizsgagyakorlas2.data.DepartmentEntityRepository;
import com.gergelygazso.springvizsgagyakorlas2.data.mapper.DepartmentEntityMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DepartmentService {

    DepartmentEntityMapper departmentEntityMapper;

    DepartmentEntityRepository departmentEntityRepository;

    public DepartmentService(DepartmentEntityMapper departmentEntityMapper, DepartmentEntityRepository departmentEntityRepository) {
        this.departmentEntityMapper = departmentEntityMapper;
        this.departmentEntityRepository = departmentEntityRepository;
    }

    public Department save(Department department) {
        DepartmentEntity savedDepartmentEntity = departmentEntityRepository.save(departmentEntityMapper.toDepartmentEntity(department));
        return departmentEntityMapper.fromDepartmentEntity(savedDepartmentEntity);
    }

    public Set<Department> findAll(){
        return departmentEntityMapper.fromDepartmentEntitySet(departmentEntityRepository.findAll());
    }
}
