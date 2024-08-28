package com.tinqinacademy.bff.api.exceptions;

public class RegistrationLoginException extends RuntimeException{
    public RegistrationLoginException(String message) {
        super(message);
    }
}
