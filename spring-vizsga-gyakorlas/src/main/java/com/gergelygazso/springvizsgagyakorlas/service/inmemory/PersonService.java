package com.gergelygazso.springvizsgagyakorlas.service.inmemory;

import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonService {

    Set<Person> persons;

    public Person save(Person person){
//        Person marci = new Person(Long.valueOf(1),"Marci", "daysLeft");
        if (persons==null){
            persons=new HashSet<Person>();
            persons.add(person);
        }else{
            persons.add(person);
        }
        return person;
    }

    public Person findById(Long id){
        Person person = persons.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow();
        return person;
    }

    public Set<Person> findAll(){
        return persons;
    }

    public Person update(Person person){
        Person personToUpdate = findById(person.getId());
        personToUpdate = person;
        return personToUpdate;
    }

    public Person delete(Long id){
        Person personToDelete = findById(id);
        persons.remove(personToDelete);
        return personToDelete;
    }

}
