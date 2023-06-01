package com.example.ohmall.models.entity;

import com.example.ohmall.exceptions.InvalidPayment;
import com.example.ohmall.fixtures.Fixture;
import com.example.ohmall.models.vo.Money;
import com.example.ohmall.models.vo.Product.Price;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest extends Fixture {
    @Test
    void calculatePrice() {
        Product product = Fixture.product("ON_SALE", new Price(10000));

        Money calculatedMoney = product.calculatePrice(3, 10000);

        assertThat(calculatedMoney.value()).isEqualTo(30000);
    }

    @Test
    void inValidProductPrice() {
        Product product = Fixture.product("ON_SALE", new Price(10001));

        assertThrows(InvalidPayment.class, () -> {
            Money calculatedMoney = product.calculatePrice(3, 10000);
        });
    }
}