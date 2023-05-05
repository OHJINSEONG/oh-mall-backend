package com.example.ohmall.models.entity;

import com.example.ohmall.dtos.OrderResultDto;
import com.example.ohmall.exceptions.InvalidPayment;
import com.example.ohmall.models.vo.Payment;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "payment"))
    private Payment payment;

    public Order() {
    }

    public Order(Payment payment) {
        this.payment = payment;
    }

    public static Order of(Product product, int payment) {
        if (!Objects.equals(payment, product.price().value())) {
            throw new InvalidPayment("Invalid payment information.");
        }

        if(product.isSoldOut()) {
            throw new InvalidPayment("Product is SoldOut.");
        }

        return new Order(new Payment(payment));
    }

    public OrderResultDto toDto() {
        return new OrderResultDto(payment.value());
    }

    public Long id() {
        return id;
    }
}
