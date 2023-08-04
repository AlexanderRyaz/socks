package com.example.socks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.AttributeNotFoundException;
import java.sql.SQLException;

@ControllerAdvice
public class SocksControllerExceptionHandler {
    @ExceptionHandler(AttributeNotFoundException.class)
    public ResponseEntity<String> handleAttributeNotFoundException(AttributeNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> handleSqlException(SQLException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
