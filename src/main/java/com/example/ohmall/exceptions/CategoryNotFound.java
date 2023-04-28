package com.example.ohmall.exceptions;

public class CategoryNotFound extends RuntimeException{
    public CategoryNotFound() {
        super("해당 카테고리가 존재하지 않습니다.");
    }
}
