package com.example.ohmall.services;

import com.example.ohmall.dtos.LogInDto;
import com.example.ohmall.exceptions.LogInError;
import com.example.ohmall.models.entity.Users;
import com.example.ohmall.repositories.UserRepository;
import com.example.ohmall.utils.JwtUtil;

public class LogInService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public LogInService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String logIn(LogInDto logInDto) {
        Users user = userRepository.findByUserName(logInDto.getUserName())
                .orElseThrow(() -> new LogInError("해당 아이디가 없습니다."));

        if(user.password().value().equals(logInDto.getPassword())){
            throw new LogInError("비밀번호가 틀렸습니다.");
        }

        return jwtUtil.encode(user.id());
    }
}
