package com.example.ohmall.models.entity;

import com.example.ohmall.exceptions.InvalidPayment;
import com.example.ohmall.fixtures.Fixture;
import com.example.ohmall.models.vo.Product.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest extends Fixture {
    @Test
    void createWithInvalidPayment() {
        Product product = Fixture.product("ON_SALE", new Price(10000));

        assertThrows(InvalidPayment.class, () -> {
            Order order = Order.of(product, 3, 10001);
        });
    }

    @Test
    void createWithProductSoldOut() {
        Product product = Fixture.product("SOLD_OUT", new Price(10000));

        assertThrows(InvalidPayment.class, () -> {
            Order order = Order.of(product, 3, 10000);
        });
    }
}