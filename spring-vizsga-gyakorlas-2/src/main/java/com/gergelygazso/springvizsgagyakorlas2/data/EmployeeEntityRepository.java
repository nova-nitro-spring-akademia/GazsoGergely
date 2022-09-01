package com.gergelygazso.springvizsgagyakorlas2.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Long> {

//    @Query("SELECT e FROM EMPLOYEE_ENTITY e WHERE e.BIRTH_YEAR<1957")
    Set<EmployeeEntity> findByBirthYearLessThan(int birthYear);
}
