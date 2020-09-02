package com.example.demo.prakash.exceptions;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ValidationException extends MethodArgumentNotValidException {
    public ValidationException(MethodParameter parameter, BindingResult bindingResult) {
        super(parameter, bindingResult);
    }
}
