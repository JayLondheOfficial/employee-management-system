package com.jay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
