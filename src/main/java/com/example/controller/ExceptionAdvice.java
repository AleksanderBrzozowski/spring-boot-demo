package com.example.controller;

import com.example.resource.ResourceNotFoundException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author Aleksander
 */

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResourceNotFoundException> handleNullPointerException(HttpServletRequest request) {
        ResourceNotFoundException exc =
                new ResourceNotFoundException("Resource not found", LocalDateTime.now(), request.getPathInfo());
        return new ResponseEntity<>(exc, HttpStatus.NOT_FOUND);
    }
}
