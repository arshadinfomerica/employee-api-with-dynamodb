package com.dynamodb.curd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dynamodb.curd.entity.Employee;
import com.dynamodb.curd.exception.EmployeeNotFound;
import com.dynamodb.curd.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private EmployeeRepository employeeRepo;
	
	public Employee addEmployee(Employee emp) {
		employeeRepo.save(emp);
		return emp;
	}
	
	 public Optional<Employee> findEmployee(String employeeId) {
		 Optional<Employee> emp=employeeRepo.findById(employeeId);
		 if(!emp.isPresent()) {
			 throw new EmployeeNotFound("Employee not found with ID " + employeeId);
		 }
	        return emp;  
	    }
	
	 public String deleteEmployee(String employeeId) {
	        Optional<Employee> empOpt = employeeRepo.findById(employeeId);
	        if (empOpt.isPresent()) {
	            employeeRepo.deleteById(employeeId); 
	            return "Employee " + employeeId + " deleted";
	        } else {
	            throw new EmployeeNotFound("Employee not found with ID " + employeeId);
	        }
	    }
	    public Employee updateEmployee(String employeeId, Employee emp) {
	        Optional<Employee> empOpt = employeeRepo.findById(employeeId);
	        if (empOpt.isPresent()) {
	            emp.setEmployeeId(employeeId); 
	           return  employeeRepo.save(emp);  
	            
	        } else {
	        	throw new EmployeeNotFound("Employee not found with ID " + employeeId);
	        }
	    }
	
	    public Iterable<Employee> getAllEmployees() {
	        return  employeeRepo.findAll();  
	    }

}
