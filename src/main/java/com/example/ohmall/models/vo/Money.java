package com.example.ohmall.models.vo;

import java.util.Objects;

public class Money {
    private final Integer value;

    protected Money() {
        this.value = null;
    }

    public Money(Integer value) {
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
                other.getClass().equals(Money.class) &&
                ((Money) other).value.equals(this.value);
    }

    @Override
    public String toString() {
        return "Payment value: " + value;
    }

    public Money multiple(int quantity) {
        int calculatedMoney = value * quantity;

        return new Money(calculatedMoney);
    }


}
