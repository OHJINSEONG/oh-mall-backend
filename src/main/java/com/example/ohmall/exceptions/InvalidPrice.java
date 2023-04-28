package com.example.ohmall.exceptions;

public class InvalidPrice extends RuntimeException {
    public InvalidPrice(int value) {
        super(value + "은 사용하실수 없는 금액입니다.");
    }
}
