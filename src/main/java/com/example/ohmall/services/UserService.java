package com.example.ohmall.services;

import com.example.ohmall.dtos.LogInDto;
import com.example.ohmall.dtos.UserDto;
import com.example.ohmall.exceptions.UserNotFound;
import com.example.ohmall.models.entity.Users;
import com.example.ohmall.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto find(Long userId) {
        return userRepository.findById(userId).map(Users::toDto).orElseThrow(UserNotFound::new);
    }
}
