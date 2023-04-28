package com.example.ohmall.exceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super("해당 상품이 없습니다.");
    }
}
