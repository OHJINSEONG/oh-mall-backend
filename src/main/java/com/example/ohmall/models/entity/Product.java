package com.example.ohmall.models.entity;

import com.example.ohmall.dtos.ProductResultDto;
import com.example.ohmall.exceptions.InvalidPayment;
import com.example.ohmall.models.vo.Money;
import com.example.ohmall.models.vo.Product.Price;
import com.example.ohmall.models.vo.Product.ProductStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private Long categoryId;

    private String productName;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "price"))
    private Price price;

    private String description;

    private String image;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Product() {
    }

    public Product(String productName, Price price, ProductStatus status) {
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public ProductResultDto toDto() {
        return new ProductResultDto(id, productName, price.value(), description, image);
    }

    public Price price() {
        return price;
    }

    public boolean isSoldOut() {
        return status.isSoldOut();
    }

    public Long id() {
        return id;
    }

    public Money calculatePrice(int quantity, int productPrice) {
        if (!Objects.equals(productPrice, price.value())) {
            throw new InvalidPayment("Invalid payment information.");
        }

        Money money = new Money(price.value());

        return money.multiple(quantity);
    }
}