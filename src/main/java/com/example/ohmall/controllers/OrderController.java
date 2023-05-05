package com.example.ohmall.controllers;

import com.example.ohmall.dtos.OrderResultDto;
import com.example.ohmall.exceptions.CategoryNotFound;
import com.example.ohmall.exceptions.InvalidPayment;
import com.example.ohmall.exceptions.InvalidPrice;
import com.example.ohmall.exceptions.ProductNotFound;
import com.example.ohmall.models.entity.Order;
import com.example.ohmall.models.vo.Payment;
import com.example.ohmall.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResultDto order(
    ) {
        Order order = orderService.order(10001, 1L);

        return order.toDto();
    }

    @ExceptionHandler(InvalidPayment.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidPayment(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(InvalidPrice.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidPrice(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String productNotFound(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(CategoryNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String categoryNotFound(Exception exception) {
        return exception.getMessage();
    }
}
