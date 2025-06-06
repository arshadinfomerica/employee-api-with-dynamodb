package com.dynamodb.curd.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String employeeId;
	
	@DynamoDBAttribute
	private String firstName;
	@DynamoDBAttribute
	private String lastName;
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private Address address;

}
