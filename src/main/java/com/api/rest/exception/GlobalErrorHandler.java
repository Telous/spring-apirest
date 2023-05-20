package com.api.rest.exception;

import com.api.rest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private ResponseObject responseObject;

    //405
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public final ResponseEntity<ResponseObject> methodNotSupported() {
        responseObject = new ResponseObject("HTTP request method not supported for this operation.");
        return new ResponseEntity<>( responseObject, HttpStatus.METHOD_NOT_ALLOWED);
    }

    //404
    @ExceptionHandler(value = { NoHandlerFoundException.class })
    public final ResponseEntity<ResponseObject> noHandlerFoundException() {
        responseObject = new ResponseObject("Unable to find resource");
        return new ResponseEntity<>( responseObject, HttpStatus.NOT_FOUND);
    }

    //constraint email violation
    @ExceptionHandler(value = { DataIntegrityViolationException.class })
    public final ResponseEntity<ResponseObject> constraintException(DataIntegrityViolationException ex) {
        responseObject = new ResponseObject("Email is already used.");
        return new ResponseEntity<>( responseObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { PatternException.class })
    public final ResponseEntity<ResponseObject> patternException(PatternException ex) {
        responseObject = new ResponseObject(ex.getMessage());
        return new ResponseEntity<>( responseObject, HttpStatus.BAD_REQUEST);
    }

}
