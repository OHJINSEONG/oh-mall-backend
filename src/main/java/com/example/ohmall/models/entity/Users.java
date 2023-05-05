package com.example.ohmall.models.entity;

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
}
