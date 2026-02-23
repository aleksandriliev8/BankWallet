package com.bank.wallet.wallet_backend.mapper;

import com.bank.wallet.wallet_backend.dto.request.UserRegistrationRequestDTO;
import com.bank.wallet.wallet_backend.dto.response.UserResponseDTO;
import com.bank.wallet.wallet_backend.dto.response.WalletResponseDTO;
import com.bank.wallet.wallet_backend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRegistrationRequestDTO userDto) {
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