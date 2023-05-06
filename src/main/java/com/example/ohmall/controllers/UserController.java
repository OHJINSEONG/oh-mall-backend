package com.example.ohmall.controllers;

import com.example.ohmall.dtos.UserDto;
import com.example.ohmall.exceptions.InvalidPrice;
import com.example.ohmall.exceptions.UserNotFound;
import com.example.ohmall.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(value = "Fetch User", notes = "fetch user by userId")
    public UserDto user(
            @RequestAttribute("userId") Long userId
    ) {
        return userService.find(userId);
    }

    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String UserNotFound(Exception exception) {
        return exception.getMessage();
    }
}
