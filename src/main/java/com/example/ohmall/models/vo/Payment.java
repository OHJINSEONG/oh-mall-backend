package com.example.ohmall.models.vo;

import java.util.Objects;

public class Payment {
    private final Integer value;

    protected Payment() {
        this.value = null;
    }

    public Payment(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object other) {
        return other != null &&
                other.getClass().equals(Payment.class) &&
                ((Payment) other).value.equals(this.value);
    }

    @Override
    public String toString() {
        return "Payment value: " + value;
    }
}
