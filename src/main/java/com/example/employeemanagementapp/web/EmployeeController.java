package com.example.employeemanagementapp.web;


import com.example.employeemanagementapp.entities.Employee;
import com.example.employeemanagementapp.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model,@RequestParam(name="keyword",defaultValue = "") String kw){
        List<Employee> employeeList = employeeRepository.findByNameContains(kw);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("keyword",kw);
        return "employees";
    }

    @GetMapping("/formEmployee")
    public String formEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "formEmployee";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        employeeRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/editEmployee")
    public String editEmployee(@RequestParam(name = "id")Long id,Model model){
       Employee employee = employeeRepository.findById(id).get();
       model.addAttribute("employee",employee);
       return "editEmployee" ;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "editEmployee";
        }
        employeeRepository.save(employee);
        return "redirect:/index?keyword="+employee.getName();
    }
}
