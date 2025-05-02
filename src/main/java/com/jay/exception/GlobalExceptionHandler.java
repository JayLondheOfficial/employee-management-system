package com.jay.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex){
		Map<String, Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp: ", LocalDateTime.now());
		errorDetails.put("message: ", ex.getMessage());
		errorDetails.put("Status: ", HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneric(Exception ex) {
		Map<String, Object> errorDetails = new HashMap<>();

		errorDetails.put("timestamp: ", LocalDateTime.now());
		errorDetails.put("message: ", "Something Went Wrong");
		errorDetails.put("Status: ", HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex){
		Map<String, String> errorDetails = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error-> errorDetails.put(error.getField(), error.getDefaultMessage()));
		
//		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
		return ResponseEntity.badRequest().body(errorDetails);
	}

}
