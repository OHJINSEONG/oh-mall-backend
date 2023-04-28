package com.example.ohmall.models.vo;

import com.example.ohmall.exceptions.InvalidPrice;
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

    @Test
    void updateWithValidPrice(){
        Price price = new Price(1000);

        price.update(2000);

        assertThat(price.value()).isEqualTo(2000);
    }

    @Test
    void updateWithInvalidPrice(){
        Price price = new Price(1000);

        assertThrows(InvalidPrice.class, () -> {
            price.update(-1000);
        });
    }
}


// 가격검사 사람맞는지검사 상품수량 검사