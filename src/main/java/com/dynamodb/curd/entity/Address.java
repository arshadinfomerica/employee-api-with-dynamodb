package com.dynamodb.curd.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBDocument
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@DynamoDBAttribute
	private String cityName;
	@DynamoDBAttribute
	private String countryName;

}
