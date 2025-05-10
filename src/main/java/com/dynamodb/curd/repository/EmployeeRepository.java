package com.dynamodb.curd.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dynamodb.curd.entity.Employee;

@Repository
@EnableScan
public interface EmployeeRepository extends CrudRepository<Employee,String> {

}
