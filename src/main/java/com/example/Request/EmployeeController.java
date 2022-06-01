package com.example.Request;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Request.model.Employee;


@org.springframework.web.bind.annotation.RestController
public class EmployeeController {
		
	@PostMapping("/emps")
  public Employee getEmp(@RequestBody Employee emp) {
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getRole());


		return emp;	
	}
	
    @PostMapping(value = "/numberTwoAPI")
	public Map<String, Object> numberTwoAPI(@RequestBody Map<String, Object> requests) throws Exception {
    System.out.println(requests);
	return requests;
}

}
