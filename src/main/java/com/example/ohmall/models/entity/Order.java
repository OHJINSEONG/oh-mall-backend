package com.example.ohmall.models.entity;

import com.example.ohmall.dtos.OrderResultDto;
import com.example.ohmall.exceptions.InvalidPayment;
import com.example.ohmall.models.vo.Money;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "payment"))
    private Money orderPrice;

    private int quantity;

    public Order() {
    }

    public Order(int quantity, Money orderPrice) {
        this.quantity = quantity;
        this.orderPrice = orderPrice;
    }

    public static Order of(Product product, int quantity, int productPrice) {
        if (product.isSoldOut()) {
            throw new InvalidPayment("Product is SoldOut.");
        }

        Money money = product.calculatePrice(quantity, productPrice);

        Order order = new Order(quantity, money);

        return order;
    }

    public OrderResultDto toDto() {
        return new OrderResultDto(orderPrice.value());
    }

    public Long id() {
        return id;
    }
}
