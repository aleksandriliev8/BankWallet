package com.bank.wallet.wallet_backend.dto.request;

import java.util.UUID;

public record UserRegistrationRequestDTO(
        UUID id,
        String firstName,
        String lastName,
        String username,
        String email,
        String password,
        Double balance,
        int age
) {
}
