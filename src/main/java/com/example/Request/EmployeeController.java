package com.example.Request;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Request.Repository.RequestRepo;
import com.example.Request.model.Employee;


@org.springframework.web.bind.annotation.RestController
public class EmployeeController {
	
	@Autowired 
	private RequestRepo rr;
		
	@PostMapping("/emps")
	public Employee addemp(@RequestBody Employee addemp) {
		System.out.println(addemp.getId());
		System.out.println(addemp.getName());
		System.out.println(addemp.getRole());
		return rr.save(addemp);
	}
  
	@PutMapping("/edit")
	public Employee editemp(@RequestBody Employee editemp) {
		System.out.println("Edited Sucessfully");
		return rr.save(editemp);
	}
	
	@DeleteMapping("/deleteemp")
	   public String deleteemp() {
		String result = "";
		try {
			rr.deleteAll();
			result = "All Employee records deleted sucessfully";
	}
	catch(Exception e) {
		result = "Error Ocurred";
	}
	return result;
}
	
	@GetMapping("/getemp")
		public List<Employee> getemp() {
			return rr.findAll();
		}
	
//    @PostMapping(value = "/numberTwoAPI")
//	public Map<String, Object> numberTwoAPI(@RequestBody Map<String, Object> requests) throws Exception {
//    System.out.println(requests);
//	return requests;
//}

}
