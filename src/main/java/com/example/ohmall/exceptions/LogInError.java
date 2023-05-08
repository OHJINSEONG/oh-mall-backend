package com.example.ohmall.exceptions;

public class LogInError extends RuntimeException{
    public LogInError(String errorMessage){
        super(errorMessage);
    }
}
