package com.gergelygazso.springvizsgagyakorlas.controller;

import com.gergelygazso.springvizsgagyakorlas.domain.Person;
import com.gergelygazso.springvizsgagyakorlas.domain.Task;
import com.gergelygazso.springvizsgagyakorlas.mapper.PersonDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.mapper.TaskFormDTOMapper;
import com.gergelygazso.springvizsgagyakorlas.service.inmemory.PersonService;
import com.gergelygazso.springvizsgagyakorlas.service.inmemory.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class ViewController {

    PersonService personService;

    PersonDTOMapper personDTOMapper;

    TaskFormDTOMapper taskFormDTOMapper;

    TaskService taskService;

    public ViewController(PersonService personService, PersonDTOMapper personDTOMapper, TaskFormDTOMapper taskFormDTOMapper, TaskService taskService) {
        this.personService = personService;
        this.personDTOMapper = personDTOMapper;
        this.taskFormDTOMapper = taskFormDTOMapper;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showTaskForm")
    public String showTaskForm(Model model){

        TaskFormDTO taskFormDTO = new TaskFormDTO();
        Set<PersonDTO> personDTOSet = personDTOMapper.toPersonDTOSet(personService.findAll());
        taskFormDTO.setAllPersonDTOs(personDTOSet);
        model.addAttribute("taskFormDTO", taskFormDTO);

//        TaskDTOWithPersonDTO dto = new TaskDTOWithPersonDTO();
//        model.addAttribute("dto", dto);
//
//        Set<Person> personsSet = personService.findAll();
//        Set<PersonDTO> allPersonDTOs = personDTOMapper.toPersonDTOSet(personsSet);
//        model.addAttribute("allPersonDTOs", allPersonDTOs);

        return "show-task-form";
    }

    @PostMapping("/savetask")
    public String saveTask(@ModelAttribute("taskFormDTO") TaskFormDTO taskFormDTO){

        PersonDTO personDTO = personDTOMapper
                .toPersonDTO(personService.findById(taskFormDTO.getPersonId()));
        taskFormDTO.setPersonDTO(personDTO);

        Task task = taskFormDTOMapper.fromTaskFormDTO(taskFormDTO);

        Task savedTask = taskService.save(task);

        return "redirect:/";
    }

}
