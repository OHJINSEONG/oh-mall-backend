package com.example.ohmall.utils;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.example.ohmall.exceptions.InvalidName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {
    @Test
    void encode(){
        JwtUtil jwtUtil = new JwtUtil("mySecret");

        Long userId = 1L;

        String jwtAccessToken = jwtUtil.encode(userId);

        Long decodedUserId = jwtUtil.decode(jwtAccessToken);

        assertThat(decodedUserId).isEqualTo(1L);
    }

    @Test
    void decode(){
        JwtUtil myKey = new JwtUtil("mySecret");
        JwtUtil anotherKey = new JwtUtil("anotherSecret");

        String jwtAccessToken = myKey.encode(1L);

        assertThrows(SignatureVerificationException.class,() -> {
            anotherKey.decode(jwtAccessToken);
        });
    }
}