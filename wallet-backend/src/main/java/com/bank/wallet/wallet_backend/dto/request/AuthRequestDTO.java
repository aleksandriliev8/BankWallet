package com.bank.wallet.wallet_backend.dto.request;

public record AuthRequestDTO(
        String username,
        String password
) {
}
