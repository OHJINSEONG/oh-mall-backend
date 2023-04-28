package com.example.ohmall.backdoor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Transactional
@RequestMapping("/backdoor")
public class BackdoorController {
    private final JdbcTemplate jdbcTemplate;

    public BackdoorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("setup-products")
    public String setupProducts() {
        jdbcTemplate.execute("DELETE from product");
        jdbcTemplate.execute("DELETE from category");

        jdbcTemplate.update("INSERT INTO " +
                        "product(" +
                        "id, category-id, product-name, price, description, status " +
                        ", created_at, updated_at" +
                        ") " +
                        "VALUES(1, 1, '테스트', 10000, '싸다', 'CREATED' ?, ?)"
                , LocalDateTime.now(), LocalDateTime.now());

        jdbcTemplate.update("INSERT INTO " +
                        "category(" +
                        "id, type " +
                        ") " +
                        "VALUES(1, '옷')"
                );


        return "product";
    }
}
