package com.dynamodb.curd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.dynamodb.curd.entity.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private DynamoDBMapper mapper;
	
	public Employee addEmployee(Employee emp) {
		mapper.save(emp);
		return emp;
	}
	
	public Employee finfById(String employeeId) {
		return mapper.load(Employee.class,employeeId);
	}
	
	public String deleteEmployee(String employeeId) {
		Employee emp=mapper.load(Employee.class,employeeId);
		mapper.delete(emp);
		return "Employee Deleted";
	
	}
	public String updateEmployee(String employeeId,Employee emp) {
		mapper.save(emp,
				new DynamoDBSaveExpression().
				withExpectedEntry("employeeId", 
						new  ExpectedAttributeValue(
								new AttributeValue().withS(employeeId))));
		return "Employee "+employeeId+" updated";
	}
	
	public List<Employee> getAllEmployees() {
        return mapper.scan(Employee.class, new DynamoDBScanExpression());
    }

}
