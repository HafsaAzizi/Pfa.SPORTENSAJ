package com.example.pfa.exceptions;

public class IncorrectCredentialsException extends RuntimeException {
    public IncorrectCredentialsException() {
        super("incorrect user credentials");
    }
}
