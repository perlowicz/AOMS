package com.example.aoms.api.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Generic Exception handler for different situations (exceptions thrown)
 */

@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * On the example of this method, if any endpoint in application throws an MethodArgumentTypeMismatchException,
     * controller will build response depending on method handleMethodArgumentTypeMismatchException implementation.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String error = ex.getName() + " should be of type " + ex.getRequiredType();
        return ResponseEntity.badRequest().body(error);
    }


}
