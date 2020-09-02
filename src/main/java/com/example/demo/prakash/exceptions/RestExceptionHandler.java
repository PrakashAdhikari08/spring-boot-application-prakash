package com.example.demo.prakash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<ApiError> handleDuplicateEmailException(DuplicateEmailException e) {
		ApiError apiError = new ApiError();
		apiError.setCause("while  checking duplicate emails!!");
		apiError.setMessage(e.getMessage());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleFieldValidationException(MethodArgumentNotValidException e) {
		String [] str =e.getMessage().split("default message");
//		System.out.println(str[2]);


		return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.EXPECTATION_FAILED);
	}

}
