package com.example.ListaTareas.settings;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handlerException(RuntimeException exception, WebRequest request){
        return ResponseEntity.badRequest().body("Runtime Exception: " + exception.getMessage());
    }
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
        return ResponseEntity.badRequest().body("Illegal Argument: " + exception.getMessage());
    }
}


