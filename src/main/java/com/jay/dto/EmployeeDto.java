package com.jay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDto {
	private Long id;
	
	@NotBlank(message = "First name is mandetory")
	private String firstName;
	
	@NotBlank(message = "Last name is mandetory")
	private String lastName;
	
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandetory")
	private String email;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
