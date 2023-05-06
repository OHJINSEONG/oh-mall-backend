package com.example.ohmall.controllers;

import com.example.ohmall.dtos.LogInDto;
import com.example.ohmall.exceptions.LogInError;
import com.example.ohmall.services.LogInService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SessionController {
    private final LogInService logInService;

    public SessionController(LogInService logInService) {
        this.logInService = logInService;
    }

    @GetMapping
    @ApiOperation(value = "Login", notes = "authentication by login")
    public String logIn(
            @RequestBody LogInDto logInDto
    ) {
        String accessToken = logInService.logIn(logInDto);

        return accessToken;
    }

    @ExceptionHandler(LogInError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String logInError(Exception exception) {
        return exception.getMessage();
    }
}
