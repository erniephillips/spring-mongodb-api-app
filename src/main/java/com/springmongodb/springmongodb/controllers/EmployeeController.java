package com.springmongodb.springmongodb.controllers;

import java.util.HashMap;
import java.util.Map;

import com.springmongodb.springmongodb.models.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

  //map of employee records
  public Map<String, Employee> employees = new HashMap<>();

  //create some employee objects
  public EmployeeController() {
    employees.put("E101", new Employee("E101", "Ernie", "Phillips", 35));
    employees.put("E102", new Employee("E102", "Katie", "Phillips", 36));
    employees.put("E103", new Employee("E103", "Emily", "Phillips", 3));
    employees.put("E104", new Employee("E104", "Kelsey", "Phillips", 2));
  }


  @GetMapping("/employee-list")
  public String getAllEmployees(Model model) {
    //put employees in the model object
    model.addAttribute("employees", employees.values());
    return "employee-list";
  }
}
