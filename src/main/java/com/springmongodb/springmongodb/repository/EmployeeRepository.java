package com.springmongodb.springmongodb.repository;

import com.springmongodb.springmongodb.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
  
}
