package com.jay.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jay.dto.EmployeeDto;
import com.jay.entity.Employee;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
	MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);
	
	EmployeeDto toDTO(Employee employee);
	Employee toEntity(EmployeeDto employeeDto);
}
