package com.dynamodb.curd.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.dynamodb.curd.repository")
public class EmployeeConfiguration {
	
	
	@Value("${aws.region}")
    private String region;

    @Value("${aws.dynamodb.endpoint}")
    private String endpoint;

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;
	
	
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
		.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey))).build();
	}
	


}
