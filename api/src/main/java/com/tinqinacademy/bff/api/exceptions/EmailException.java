package com.tinqinacademy.bff.api.exceptions;

public class EmailException extends RuntimeException{
    public EmailException(String message) {
        super(message);
    }
}
