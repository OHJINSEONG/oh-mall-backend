package com.example.ohmall.fixtures;

import com.example.ohmall.models.entity.Product;
import com.example.ohmall.models.vo.Product.Price;
import com.example.ohmall.models.vo.Product.ProductStatus;

public class Fixture {
    protected static Product product(String status, Price price) {
        return new Product("장난감", price, ProductStatus.valueOf(status));
    }
}
