package com.tinqinacademy.bff.api.exceptions;

public class TokenException extends RuntimeException{
    public TokenException(String message) {
        super(message);
    }
}
