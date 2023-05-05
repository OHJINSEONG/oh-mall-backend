package com.example.ohmall.models.vo;

import com.example.ohmall.exceptions.InvalidPrice;
import com.example.ohmall.models.vo.Product.Price;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    void createWithValidPrice(){
        Price price = new Price(1000);
    }

    @Test
    void createWithInvalidPrice(){
        assertThrows(InvalidPrice.class, () -> {
            Price price = new Price(-1000);
        });
    }
}
