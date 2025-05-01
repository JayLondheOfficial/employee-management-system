package com.jay.service;

import java.util.List;

import com.jay.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employee);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto getEmployeeById(Long id);
	EmployeeDto updateEmployee(Long id, EmployeeDto employee);
	void deleteEmployee(Long id);
	
	

}
