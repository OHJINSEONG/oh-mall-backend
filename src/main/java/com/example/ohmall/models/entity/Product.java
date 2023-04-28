package com.example.ohmall.models.entity;

import com.example.ohmall.dtos.ProductResultDto;
import com.example.ohmall.models.vo.Price;
import com.example.ohmall.models.vo.ProductStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Product() {
    }

    public Product(String productName, Price price) {
        this.productName = productName;
        this.price = price;
    }

    public ProductResultDto toDto() {
        return new ProductResultDto(id, productName, price.value());
    }
}
