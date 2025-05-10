package com.dynamodb.curd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalHandleException {
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<String> employeeNotFound(EmployeeNotFound ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}

}
