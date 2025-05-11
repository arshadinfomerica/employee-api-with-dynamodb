package com.dynamodb.curd.repository;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dynamodb.curd.entity.Employee;

@Repository
@EnableScan
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,String> {

	Iterable<Employee> findAll(Sort sort);

	Iterable<Employee> findAll();

	Employee save(Employee emp);
	
	Optional<Employee> findById(String employeeId);

	void deleteById(String employeeId);

}
