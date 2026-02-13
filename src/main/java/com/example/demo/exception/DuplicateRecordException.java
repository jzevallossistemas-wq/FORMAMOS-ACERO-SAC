package com.example.demo.exception;

public class DuplicateRecordException extends RuntimeException {
    
    public DuplicateRecordException(String message) {
        super(message);
    }
    
    public DuplicateRecordException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s ya existe con %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
