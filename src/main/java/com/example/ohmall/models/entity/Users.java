package com.example.ohmall.models.entity;

import com.example.ohmall.dtos.UserDto;
import com.example.ohmall.models.vo.User.Password;
import com.example.ohmall.models.vo.User.UserName;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_name"))
    private UserName userName;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "password"))
    private Password password;

    public Users() {
    }

    public Users(Long id, UserName userName, Password password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UserDto toDto() {
        return new UserDto(userName.value());
    }

    public Long id() {
        return id;
    }

    public Password password() {
        return password;
    }
}
