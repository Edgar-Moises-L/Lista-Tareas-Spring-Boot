package com.example.ListaTareas.settings;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handlerException(RuntimeException exception, WebRequest request){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
