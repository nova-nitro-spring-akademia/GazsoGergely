package com.gergelygazso.springvizsgagyakorlas2.controller.view;

import com.gergelygazso.springvizsgagyakorlas2.controller.EmployeeDTO;
import com.gergelygazso.springvizsgagyakorlas2.controller.EmployeeListView;
import com.gergelygazso.springvizsgagyakorlas2.controller.mapper.EmployeeDTOMapper;
import com.gergelygazso.springvizsgagyakorlas2.service.Employee;
import com.gergelygazso.springvizsgagyakorlas2.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class ViewController {

    EmployeeService employeeService;

    EmployeeDTOMapper employeeDTOMapper;

    public ViewController(EmployeeService employeeService, EmployeeDTOMapper employeeDTOMapper) {
        this.employeeService = employeeService;
        this.employeeDTOMapper = employeeDTOMapper;
    }

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/employeelist")
    public String showEmployeeList(Model model){
        //raise feature előtti állapot
//        Set<Employee> employeeSet = employeeService.findAll();
//        Set<EmployeeDTO> employeeDTOSet = employeeDTOMapper.toEmployeeDTOSet(employeeSet);
//        model.addAttribute("employeeDTOSet",employeeDTOSet);

        Set<Employee> employeeSet = employeeService.findAll();
        Set<EmployeeDTO> employeeDTOSet = employeeDTOMapper.toEmployeeDTOSet(employeeSet);
        EmployeeListView employeeListView = new EmployeeListView();
        employeeDTOSet.stream().forEach(eDTO -> employeeListView.addKeyValuePair(eDTO, employeeDTOMapper.fromEmployeeDTO(eDTO).isRaiseDue()));
        model.addAttribute("employeeListView", employeeListView);



        return "employee-list";
    }

    @GetMapping("/employeecreate")
    public String showEmployeCreate(Model model){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        model.addAttribute("employeeDTO",employeeDTO);
        return "employee-create";
    }

    @PostMapping("/saveemployee")
    public String saveEmployee(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO){
        Employee employee = employeeDTOMapper.fromEmployeeDTO(employeeDTO);
        employeeService.save(employee);
        return "redirect:/employeelist";
    }

}