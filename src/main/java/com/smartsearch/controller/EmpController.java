package com.smartsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartsearch.entity.EmployeeDetails;
import com.smartsearch.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmpController {
	
	@Autowired
	private EmployeeRepository empRepository; 
	
	@PostMapping("/addemp")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDetails employee){
		EmployeeDetails save = empRepository.save(employee);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/getemp")
	public ResponseEntity<?> getEmployee(){
		return ResponseEntity.ok(empRepository.findAll());
	}
	
	 @DeleteMapping("/delete/{empName}")
	    public String deleteEmployee(@PathVariable String empName){
	        empRepository.deleteById("empName");
	        
	        return "Deleted Successfully";
	 } 

	 @GetMapping("/search/{query}")
	 public ResponseEntity<?> search(@PathVariable("query") String query){
		List<EmployeeDetails> employee = this.empRepository.findAllByEmpNameContaining(query);
		return ResponseEntity.ok(employee);
	} 
	 
	/* @GetMapping("/search/{empName}")
		public ResponseEntity<?> searchStudents(@RequestParam("empName") String empName){
			return ResponseEntity.ok(empRepository.findAllByEmpNameContaining(empName));
		}  */
	 
} 
