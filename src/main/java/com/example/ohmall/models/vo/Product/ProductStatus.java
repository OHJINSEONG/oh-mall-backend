package com.example.ohmall.models.vo.Product;

public enum ProductStatus {
    ON_SALE("ON_SALE"),
    SOLD_OUT("SOLD_OUT");

    private String status;

    ProductStatus() {
    }

    ProductStatus(String status) {
        this.status = status;
    }

    public String value() {
        return status;
    }

    public boolean isSoldOut() {
        return value().equals("SOLD_OUT");
    }
}
