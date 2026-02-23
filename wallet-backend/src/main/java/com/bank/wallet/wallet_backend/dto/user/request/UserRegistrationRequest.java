package com.bank.wallet.wallet_backend.dto.user.request;

import java.util.UUID;

public record UserRegistrationRequest(
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
