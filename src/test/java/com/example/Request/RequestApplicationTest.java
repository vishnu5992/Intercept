package com.example.Request;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Request.Repository.RequestRepo;
import com.example.Request.model.Employee;
import com.example.Request.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestApplicationTest {

	@Autowired
	private EmployeeService service;
	
	@MockBean
	private RequestRepo repo;
	
	@Test
	public void getUserTest() {
		when(repo.findAll()).thenReturn(Stream.of(new Employee("1","vishnu","dev"), new Employee("2","kabil","dev")).collect(Collectors.toList()));
		assertEquals(2,service.getUser().size());
	}
	
	@Test
	public void saveUserTest() {
		Employee emp = new Employee("3","jegan","dev");
		when(repo.save(emp)).thenReturn(emp);
		assertEquals(emp,service.addUser(emp));
	}
	
	@Test
	public void deleteUserTest() {
		Employee emp = new Employee("3","jegan","dev");
		assertEquals("deleted", service.deleteUser(emp));
	}
	
	@Test
	public void editUserTest() {
		Employee emp = new Employee("3","jegan","dev");
        service.editUser(emp);
	}
}
