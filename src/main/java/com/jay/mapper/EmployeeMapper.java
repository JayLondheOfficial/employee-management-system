package com.jay.mapper;

import com.jay.dto.EmployeeDto;
import com.jay.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto toDTO(Employee employee) {
		
		EmployeeDto dto = new EmployeeDto(employee.getId(),employee.getFirstName(), employee.getLastName(), employee.getEmail());
		return dto;
	}
	
public static Employee toEntity(EmployeeDto dto) {
		
		Employee employee = new Employee();
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		return employee;
	}

}
