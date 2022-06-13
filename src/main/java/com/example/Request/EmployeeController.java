package com.example.Request;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Request.Repository.RequestRepo;
import com.example.Request.model.Employee;
import com.example.Request.service.EmployeeService;


@org.springframework.web.bind.annotation.RestController
public class EmployeeController {
	
	@Autowired 
	private EmployeeService rr;
		
	@PostMapping("/emps")
	public Employee addemp(@RequestBody Employee addemp) {
		System.out.println(addemp.getId());
		System.out.println(addemp.getName());
		System.out.println(addemp.getRole());
		System.out.println(addemp);
		return rr.addUser(addemp);
	}
  
	@PutMapping("/edit")
	public Employee editemp(@RequestBody Employee editemp) {
		System.out.println("Edited Sucessfully");
		return rr.editUser(editemp);
	}
	
	@DeleteMapping("/deleteemp")
	  public Employee removeEmp(@RequestBody Employee delemp) {
		      rr.deleteUser(delemp);
		      return delemp;	
	}
	
	@GetMapping("/getemp")
		public List<Employee> getemp() {
			return rr.getUser();
		}
	
    @PostMapping(value = "/numberTwoAPI")
	public Map<String, Object> numberTwoAPI(@RequestBody Map<String, Object> requests) throws Exception {
    System.out.println(requests);
	return requests;
}

}
