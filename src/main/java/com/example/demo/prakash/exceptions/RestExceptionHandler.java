package com.example.demo.prakash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<ApiError> handleDuplicateEmailException(DuplicateEmailException e) {
		ApiError apiError = new ApiError();
		apiError.setCause("while  checking duplicate emails!!");
		apiError.setMessage(e.getMessage());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> handleFieldValidationException(ValidationException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
	}

}
