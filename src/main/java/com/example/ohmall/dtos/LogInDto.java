package com.example.ohmall.dtos;

public class LogInDto {
    private String userName;
    private String password;

    public LogInDto() {
    }

    public LogInDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
