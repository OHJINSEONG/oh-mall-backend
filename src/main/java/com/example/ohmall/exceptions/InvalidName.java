package com.example.ohmall.exceptions;

public class InvalidName extends RuntimeException {
    public InvalidName(String value) {
        super(value+"는 사용하실 수 없는 이름입니다.");
    }
}
