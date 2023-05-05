package com.example.ohmall.models.vo.User;

import com.example.ohmall.exceptions.InvalidName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UsersNameTest {
    @Test
    void createWithValidUserName(){
        UserName userName = new UserName("오진성짱");

        assertThat(userName.value()).isEqualTo("오진성짱");
    }

    @Test
    void createWithInvalidUserName(){
        assertThrows(InvalidName.class, () -> {
            UserName userName = new UserName("오진");
        });
    }
}