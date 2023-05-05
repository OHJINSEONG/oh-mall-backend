package com.example.ohmall.exceptions;

public class InvalidPayment extends RuntimeException {
    public InvalidPayment(String errorMessage) {
        super(errorMessage);
    }
}
