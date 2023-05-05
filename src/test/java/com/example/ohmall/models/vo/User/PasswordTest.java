package com.example.ohmall.models.vo.User;

import com.example.ohmall.exceptions.InvalidName;
import com.example.ohmall.exceptions.InvalidPassword;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
    @Test
    void createWithValidPassword(){
        Password password = new Password("오진성짱");

        assertThat(password.value()).isEqualTo("오진성짱");
    }

    @Test
    void createWithInvalidPassword(){
        assertThrows(InvalidPassword.class, () -> {
            Password password = new Password("비밀번호1232123123123123");
        });
    }

}