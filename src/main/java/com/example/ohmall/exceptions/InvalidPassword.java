package com.example.ohmall.exceptions;

public class InvalidPassword extends RuntimeException {
    public InvalidPassword(String value) {
        super(value + "현태가 올바르지 않습니다.");
    }
}
