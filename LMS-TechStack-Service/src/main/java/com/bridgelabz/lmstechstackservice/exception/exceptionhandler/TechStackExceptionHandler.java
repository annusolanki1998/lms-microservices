package com.bridgelabz.lmstechstackservice.exception.exceptionhandler;

import com.bridgelabz.lmstechstackservice.exception.CustomValidationException;
import com.bridgelabz.lmstechstackservice.exception.TechStackNotFoundException;
import com.bridgelabz.lmstechstackservice.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TechStackExceptionHandler {

    /*
     * Purpose : TechStackNotFoundException is used to handle the exceptions
     * Version : 1.0
     * @author : Annu kumari
     * */

    @ExceptionHandler(TechStackNotFoundException.class)
    public ResponseEntity<Response> handlerHiringException(TechStackNotFoundException exception) {
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
     * Purpose : MethodArgumentNotValidException is used to handle the exceptions
     * Version : 1.0
     * @author : Annu kumari
     * */


    // Using custom exception for handling the error of validation part
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomValidationException> customValidationException(MethodArgumentNotValidException exception) {
        CustomValidationException customValidationException = new CustomValidationException();
        customValidationException.setErrorCode(400);
        customValidationException.setMessage(exception.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(customValidationException, HttpStatus.BAD_REQUEST);
    }


}
