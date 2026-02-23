package com.bank.wallet.wallet_backend.controller;

import com.bank.wallet.wallet_backend.dto.user.request.UserRegistrationRequest;
import com.bank.wallet.wallet_backend.dto.user.response.UserResponseDTO;
import com.bank.wallet.wallet_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody UserRegistrationRequest userDto) {
        return userService.registerUser(userDto);
    }
}