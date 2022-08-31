package com.gergelygazso.springvizsgagyakorlas.service;

import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class PersonService {

    public Person add(String name){
        Person marci = new Person(Long.valueOf(1),"Marci", "daysLeft");
        return marci;
    }

    public Person findById(Long id){
        Person marci = new Person(Long.valueOf(1),"Marci", "daysLeft");
        return marci;
    }

    public Set<Person> findAll(){
        Person marci = new Person(Long.valueOf(1),"Marci", "daysLeft");
        Person emma = new Person(Long.valueOf(2),"Emma", "priority");
        return Set.of(marci, emma);
    }

    public

}
