package com.tinqinacademy.bff.api.exceptions;

public class QueryException extends RuntimeException {
    public QueryException(String message) {
        super(message);
    }
}
