package com.bank.wallet.wallet_backend.mapper;

import com.bank.wallet.wallet_backend.dto.user.request.UserRegistrationRequest;
import com.bank.wallet.wallet_backend.dto.user.response.UserResponseDTO;
import com.bank.wallet.wallet_backend.dto.wallet.response.WalletResponseDTO;
import com.bank.wallet.wallet_backend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRegistrationRequest userDto) {
        User user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setAge(userDto.age());
        return user;
    }

    public UserResponseDTO toResponse(User user, WalletResponseDTO walletDto) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                walletDto
        );
    }
}