package com.example.Request.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Request.model.Employee;

@Repository
public interface RequestRepo extends JpaRepository<Employee,String> {

	

}
