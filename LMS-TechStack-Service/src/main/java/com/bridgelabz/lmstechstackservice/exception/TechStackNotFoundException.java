package com.bridgelabz.lmstechstackservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Purpose : TechStackNotFoundException is used to handle the exceptions
 * Version : 1.0
 * @author : Annu kumari
 * */

@ResponseStatus
public class TechStackNotFoundException extends RuntimeException {
    private int statusCode;
    private String statusMessage;

    public TechStackNotFoundException(int statusCode, String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
