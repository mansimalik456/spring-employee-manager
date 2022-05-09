package com.smartsearch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartsearch.entity.EmployeeDetails;


@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeDetails, String>{
	
	public List<EmployeeDetails> findAllByEmpNameContaining(String empName);
	
//	public List<String> findAllByEmpNameContaining(String empName);
	

}
