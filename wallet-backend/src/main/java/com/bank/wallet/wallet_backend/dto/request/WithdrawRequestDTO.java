package com.bank.wallet.wallet_backend.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record WithdrawRequestDTO(
        @NotNull(message = "User ID is required")
        UUID userId,

        @NotNull(message = "Amount is required")
        @Positive(message = "Withdraw amount must be greater than zero")
        Double amount
) {
}
