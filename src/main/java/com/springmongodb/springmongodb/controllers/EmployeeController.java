package com.springmongodb.springmongodb.controllers;

import java.util.List;

import com.springmongodb.springmongodb.models.Employee;
import com.springmongodb.springmongodb.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepository;

  //get all employee records
  @GetMapping("/employee-list")
  public String getAllEmployees(Model model) {
    //put employees in the model object
    List<Employee> employees = employeeRepository.findAll();
    model.addAttribute("employees", employees);
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
    employeeRepository.insert(employee);
    List<Employee> employees = employeeRepository.findAll();
    model.addAttribute("employees", employees);
    return "list-employee";
  }

  //get page for edit employee
  @GetMapping("/employee/edit/{id}")
  public String editEmployee(@PathVariable("id") String id, Model model){
    var employee = employeeRepository.findById(id);
    model.addAttribute("editEmployee", employee.get());
    return "edit-employee";
  }

  //post - update the employee record
  @PostMapping("/employee/edit/{id}")
  public String updateEmployee(@PathVariable("id") String id, @ModelAttribute("editEmployee") Employee employee, Model model){
    //update the employee record. Had to add id as hidden field in edit form, and add a setter method to properly save incoming model
    employeeRepository.save(employee);

    List<Employee> employees = employeeRepository.findAll();
    model.addAttribute("employees", employees);
    return "list-employee";
  }

  //delete method
  @GetMapping("/employee/delete/{id}")
  public String deleteEmployee(@PathVariable("id") String id, Model model){
    //remove employee
    employeeRepository.deleteById(id);

    //get list of employees and return to list page
    List<Employee> employees = employeeRepository.findAll();
    model.addAttribute("employees", employees);
    return "list-employee";
  }
}
