package com.example.Request.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Request.Repository.RequestRepo;
import com.example.Request.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private RequestRepo repo;
	
	public Employee addUser(Employee emp) {
		return repo.save(emp);
	}
	
	public Employee editUser(Employee emp) {
		return repo.save(emp);
		
	}
	
	public String deleteUser(Employee emp) {
		repo.deleteAll();
		return "deleted";
	}
	
	public List<Employee> getUser(){
		List<Employee> emp = repo.findAll();
		System.out.println(emp);
		return emp;
		
	}
}
