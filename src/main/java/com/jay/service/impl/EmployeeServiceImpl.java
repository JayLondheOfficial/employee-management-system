package com.jay.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jay.entity.Employee;
import com.jay.repository.EmployeeRepository;
import com.jay.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id).get();
		
		if(existingEmployee !=null) {
			
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
			
		}else
			return null;
		
		return employeeRepository.save(existingEmployee);

		
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
		
	}

	
	

}
