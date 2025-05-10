package com.dynamodb.curd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynamodb.curd.entity.Employee;
import com.dynamodb.curd.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeRepo;
	
	
	
	 	@PostMapping
	    public ResponseEntity<Employee> save(@RequestBody Employee emp) {
	 		
	        return new ResponseEntity<>(employeeRepo.addEmployee(emp),HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public Optional<Employee> getById(@PathVariable String id) {
	        return employeeRepo.findEmployee(id);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> delete(@PathVariable String id) {
	    	employeeRepo.deleteEmployee(id);
	        return ResponseEntity.ok("Deleted");
	    }
	    
	    @PutMapping("/{id}")
	    public Employee updateEmployee(@PathVariable("id") String id, @RequestBody Employee emp) {
	       
	        	return employeeRepo.updateEmployee(id, emp);
	           
	    }
	    
	    @GetMapping
	    public Iterable<Employee> getAllEmployees() {
	        return employeeRepo.getAllEmployees();
	    }

}
