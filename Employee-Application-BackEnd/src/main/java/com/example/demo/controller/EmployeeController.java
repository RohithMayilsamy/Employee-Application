package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	private EmployeeRepository eRepo;
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return eRepo.findAll();
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id)
	{
		return eRepo.findById(id).get();
	}
	@PostMapping("/employees")
	public Employee saveEmployeeDetails(@RequestBody Employee employee)
	{
		return eRepo.save(employee);
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return eRepo.save(employee);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id)
	{
		eRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
