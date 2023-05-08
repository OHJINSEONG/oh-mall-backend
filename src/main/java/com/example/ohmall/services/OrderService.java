package com.example.ohmall.services;

import com.example.ohmall.exceptions.InvalidPayment;
import com.example.ohmall.models.entity.Order;
import com.example.ohmall.models.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Service
@Transactional
public class OrderService {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public OrderService() {
    }

    public Order order(int payment, Long productId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Product product = entityManager.find(Product.class, productId);

            Order order = Order.of(product, payment);

            entityManager.persist(order);

            System.out.println("주문 식별자 : " + order.id());

            entityTransaction.commit();
            entityManager.close();

            return order;
        } catch (Exception exception) {
            System.out.println("트랜잭션 에러");
            System.out.println(exception.getMessage());
            entityTransaction.rollback();
            entityManager.close();

            throw new InvalidPayment(exception.getMessage());
        }
    }
}