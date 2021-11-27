package com.hcardenas.brewery.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException err) {
        List<String> errorList = new ArrayList<>(err.getConstraintViolations().size());

        err.getConstraintViolations().forEach(constrains -> {
            errorList.add(constrains.toString());
        });

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
