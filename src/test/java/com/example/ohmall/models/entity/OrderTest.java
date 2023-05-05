package com.example.ohmall.models.entity;

import com.example.ohmall.exceptions.InvalidPayment;
import com.example.ohmall.fixtures.Fixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest extends Fixture {
    @Test
    void createWithInvalidPayment() {
        assertThrows(InvalidPayment.class, () -> {
            Order order = Order.of(Fixture.product("ON_SALE"), 10001);
        });
    }

    @Test
    void createWithProductSoldOut() {
        Product product = Fixture.product("SOLD_OUT");

        assertThrows(InvalidPayment.class, () -> {
            Order order = Order.of(product, 10000);
        });
    }
}