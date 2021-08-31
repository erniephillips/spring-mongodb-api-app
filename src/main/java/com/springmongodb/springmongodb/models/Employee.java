package com.springmongodb.springmongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employees") //declare as a mongodb document of type employee
public class Employee {
  @Id //tell spring id is unique identifier
  private String id;
  private String empId;
  //@Field(Name = "First Name")
  private String firstName;
  private String lastName;
  private int age;


  public Employee() {
  }


  public Employee(String id, String empId, String firstName, String lastName, int age) {
    this.id = id;
    this.empId = empId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }



  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmpId() {
    return this.empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
