package com.jay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.jay.dto.EmployeeDto;

import com.jay.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
	List<EmployeeDto> employeesDto= employeeService.getAllEmployees();
		
		return ResponseEntity.ok(employeesDto);
	}
	
	@PostMapping
	public EmployeeDto saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
		return employeeService.saveEmployee(employeeDto);
	}
	

	@GetMapping("/{id}")
	public  EmployeeDto getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeDto employee) {
		return employeeService.updateEmployee( id, employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted successfully with id : "+id;
	}
	

}
