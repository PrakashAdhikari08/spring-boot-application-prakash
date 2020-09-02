package com.example.demo.prakash.exceptions;

import lombok.Data;

@Data
public class ApiError {

	private String message;

	private String cause;

}
