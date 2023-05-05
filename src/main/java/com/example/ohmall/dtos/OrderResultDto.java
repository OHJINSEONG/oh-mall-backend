package com.example.ohmall.dtos;

public class OrderResultDto {
    private int payment;

    public OrderResultDto(int payment) {
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }
}
