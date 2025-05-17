package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exe.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exe.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
