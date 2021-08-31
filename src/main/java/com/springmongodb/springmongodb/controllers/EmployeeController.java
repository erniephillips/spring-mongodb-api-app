package com.springmongodb.springmongodb.controllers;

import java.util.HashMap;
import java.util.Map;

import com.springmongodb.springmongodb.models.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

  //map of employee records
  public Map<String, Employee> employees = new HashMap<>();

  //create employee objects
  public EmployeeController() {
    employees.put("E101", new Employee("E101", "Ernie", "Phillips", 35));
    employees.put("E102", new Employee("E102", "Katie", "Phillips", 36));
    employees.put("E103", new Employee("E103", "Emily", "Phillips", 3));
    employees.put("E104", new Employee("E104", "Kelsey", "Phillips", 2));
  }

  //get all employee records
  @GetMapping("/employee-list")
  public String getAllEmployees(Model model) {
    //put employees in the model object
    model.addAttribute("employees", employees.values());
    return "list-employee";//string must match html file naem
  }

  

  //return form for adding employee
  @GetMapping("/employee/add")
  public String addEmployee(){
    return "add-employee";
  }

  //post employee record
  @PostMapping("/employee/add")
  public String addEmployee(@ModelAttribute("addEmployee") Employee employee, Model model){
    employees.put(employee.getId(), employee);
    model.addAttribute("employees", employees.values());
    return "list-employee";
  }

  //get page for edit employee
  @GetMapping("/employee/edit/{id}")
  public String editEmployee(@PathVariable("id") String empId, Model model){
    model.addAttribute("editEmployee", employees.get(empId));
    return "edit-employee";
  }

  //post - update the employee record
  @PostMapping("/employee/edit/{id}")
  public String updateEmployee(@PathVariable("id") String empId, @ModelAttribute("editEmployee") Employee employee, Model model){
    employees.put(empId, employee);
    model.addAttribute("employees", employees.values());
    return "list-employee";
  }

  //delete method
  @GetMapping("/employee/delete/{id}")
  public String deleteEmployee(@PathVariable("id") String empId, Model model){
    //remove employee
    employees.remove(empId);

    //get list of employees and return to list page
    model.addAttribute("employees", employees.values());
    return "list-employee";
  }
}
