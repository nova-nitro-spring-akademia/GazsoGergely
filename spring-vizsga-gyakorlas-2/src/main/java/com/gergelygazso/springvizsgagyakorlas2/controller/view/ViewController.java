package com.gergelygazso.springvizsgagyakorlas2.controller.view;

import com.gergelygazso.springvizsgagyakorlas2.controller.DepartmentDTO;
import com.gergelygazso.springvizsgagyakorlas2.controller.DepartmentFormView;
import com.gergelygazso.springvizsgagyakorlas2.controller.EmployeeDTO;
import com.gergelygazso.springvizsgagyakorlas2.controller.EmployeeListView;
import com.gergelygazso.springvizsgagyakorlas2.controller.mapper.DepartmentDTOMapper;
import com.gergelygazso.springvizsgagyakorlas2.controller.mapper.DepartmentFormViewMapper;
import com.gergelygazso.springvizsgagyakorlas2.controller.mapper.EmployeeDTOMapper;
import com.gergelygazso.springvizsgagyakorlas2.data.EmployeeEntity;
import com.gergelygazso.springvizsgagyakorlas2.data.mapper.DepartmentEntityMapper;
import com.gergelygazso.springvizsgagyakorlas2.data.mapper.EmployeeEntityMapper;
import com.gergelygazso.springvizsgagyakorlas2.service.Department;
import com.gergelygazso.springvizsgagyakorlas2.service.DepartmentService;
import com.gergelygazso.springvizsgagyakorlas2.service.Employee;
import com.gergelygazso.springvizsgagyakorlas2.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class ViewController {

    EmployeeService employeeService;

    EmployeeDTOMapper employeeDTOMapper;

    EmployeeEntityMapper employeeEntityMapper;

    DepartmentFormViewMapper departmentFormViewMapper;

    DepartmentService departmentService;
    
    DepartmentDTOMapper departmentDTOMapper;

    public ViewController(EmployeeService employeeService, EmployeeDTOMapper employeeDTOMapper, EmployeeEntityMapper employeeEntityMapper, DepartmentFormViewMapper departmentFormViewMapper, DepartmentService departmentService, DepartmentDTOMapper departmentDTOMapper) {
        this.employeeService = employeeService;
        this.employeeDTOMapper = employeeDTOMapper;
        this.employeeEntityMapper = employeeEntityMapper;
        this.departmentFormViewMapper = departmentFormViewMapper;
        this.departmentService = departmentService;
        this.departmentDTOMapper = departmentDTOMapper;
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

    @GetMapping("/departmentform")
    public String showDepartmentForm(Model model){
        DepartmentFormView departmentFormView = new DepartmentFormView();
        model.addAttribute("departmentFormView", departmentFormView);
        return "department-form";
    }

    @PostMapping("/savedepartment")
    public String saveDepartment(@ModelAttribute("departmentFormView") DepartmentFormView departmentFormView){
        Department department = departmentFormViewMapper.fromDepartmentFormView(departmentFormView);
        departmentService.save(department);
        return "redirect:/";
    }

    @GetMapping("/showassignform/{id}")
    public String showAssignEmployeeToDepartmentForm(@PathVariable Long id,Model model){

        Set<DepartmentDTO> departmentDTOSet = departmentDTOMapper.toDepartmentDTOSet(departmentService.findAll());
        Employee employee = employeeService.findById(id);
        boolean hasRightForRaise = employee.isLastSalaryTwoYearsAgo();
        EmployeeDTO employeeDTO = employeeDTOMapper.toEmployeeDTO(employee);
        Long emp_id=Long.valueOf(0);
        Long raise=Long.valueOf(0);
        Long dep_id=Long.valueOf(0);

        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("departmentDTOSet", departmentDTOSet);
        model.addAttribute("hasRightForRaise", hasRightForRaise);
        model.addAttribute("emp_id", emp_id);
        model.addAttribute("raise", raise);
        model.addAttribute("dep_id", dep_id);
        return  "assign-form";
    }

    @PostMapping("/assignemptodep")
    public String assignEmployeeToDepartment(
            @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
            @RequestParam(value = "department_id") Long department_id
    ){
        Department department = departmentService.findById(department_id);
        Employee employee = employeeService.findById(employeeDTO.getId());
        EmployeeEntity employeeEntity = employeeEntityMapper.toEmployeeEntity(employee);
        employeeEntity.setSalary(employeeDTO.getSalary());
        department.assignEmployee(employeeEntity);

        departmentService.save(department);
        return "redirect:/";
    }

}
