package com.dynamodb.curd.exception;

public class EmployeeNotFound extends RuntimeException{
	
	public EmployeeNotFound(String message) {
		super(message);
	}

}
