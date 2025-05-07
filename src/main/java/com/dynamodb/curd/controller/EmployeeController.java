package com.dynamodb.curd.controller;

import java.util.List;

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
import com.dynamodb.curd.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	
	 	@PostMapping
	    public ResponseEntity<Employee> save(@RequestBody Employee emp) {
	 		;
	        return new ResponseEntity<>(employeeRepo.addEmployee(emp),HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getById(@PathVariable String id) {
	        return ResponseEntity.ok(employeeRepo.finfById(id));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> delete(@PathVariable String id) {
	    	employeeRepo.deleteEmployee(id);
	        return ResponseEntity.ok("Deleted");
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateEmployee(@PathVariable("id") String id, @RequestBody Employee emp) {
	        try {
	        	employeeRepo.updateEmployee(id, emp);
	            return ResponseEntity.ok("Employee updated successfully.");
	        } catch (RuntimeException ex) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	        }
	    }
	    
	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeRepo.getAllEmployees();
	    }

}
