package com.jay.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jay.dto.EmployeeDto;
import com.jay.entity.Employee;
import com.jay.mapper.MapStructMapper;
import com.jay.repository.EmployeeRepository;
import com.jay.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	private EmployeeRepository employeeRepository;
	private MapStructMapper employeeMapper;
	
	
	
	
public EmployeeServiceImpl(EmployeeRepository employeeRepository, MapStructMapper employeeMapper) {
		super();
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}

//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		super();
//		this.employeeRepository = employeeRepository;
//	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee = employeeMapper.toEntity(employeeDto);
		
		
		
		employeeRepository.save(employee);
		
		return employeeMapper.toDTO(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		

		List<Employee> employees =employeeRepository.findAll();
		
		return employees.stream().map(emp-> employeeMapper.toDTO(emp)).toList();
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		logger.info("getting employee with id : {}",id);
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
		return employeeMapper.toDTO(employee);
		
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		Employee existingEmployee = employeeRepository.findById(id).orElse(null);
		existingEmployee.setFirstName(employeeDto.getFirstName());
		existingEmployee.setLastName(employeeDto.getLastName());
		existingEmployee.setEmail(employeeDto.getEmail());
		
		employeeRepository.save(existingEmployee);

		

		return employeeMapper.toDTO(existingEmployee);

	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
		
	}

	
	

}
