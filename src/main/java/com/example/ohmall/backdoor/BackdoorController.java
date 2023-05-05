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

        for(int i = 1 ; i < 30 ; i +=1) {
            jdbcTemplate.update("INSERT INTO " +
                            "product(" +
                            "id, category_id, product_name, price, description, image, status " +
                            ", created_at, updated_at" +
                            ") " +
                            "VALUES(?, 1, ?, 10000, '엄청나게 향기로운 사기향수', 'https://user-images.githubusercontent.com/107606892/235420874-d03cf788-2fa3-464f-912a-b55185aa05ab.png' ,'ON_SALE', ?, ?)"
                    ,i ,"테스트상품"+i ,LocalDateTime.now(), LocalDateTime.now());
        }

        jdbcTemplate.update("INSERT INTO " +
                        "category(" +
                        "id, type " +
                        ") " +
                        "VALUES(1, '옷')"
                );


        return "product";
    }

    @GetMapping("setup-users")
    public String setupUsers() {
        jdbcTemplate.execute("DELETE from user");

        jdbcTemplate.update("INSERT INTO " +
                        "user(" +
                        "id, category_id, product_name, price, description, status " +
                        ", created_at, updated_at" +
                        ") " +
                        "VALUES(1, 1, '테스트', 10000, '싸다', 'CREATED', ?, ?)"
                , LocalDateTime.now(), LocalDateTime.now());

        return "user";
    }
}
