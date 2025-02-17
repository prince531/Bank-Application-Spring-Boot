package com.example.banksystem1.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloableExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handelNullPointerException(NullPointerException npe){
        return ResponseEntity.status(500).body("Null Pointer Exception");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handelException(Exception e){
        return ResponseEntity.status(500).body(e.getMessage());
    }

    
}
