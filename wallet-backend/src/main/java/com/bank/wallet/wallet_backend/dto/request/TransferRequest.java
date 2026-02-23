package com.bank.wallet.wallet_backend.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record TransferRequest(
        @NotNull(message = "Source user ID is required")
        UUID fromUserId,

        @NotNull(message = "Target user ID is required")
        UUID toUserId,

        @NotNull(message = "Amount is required")
        @Positive(message = "Transfer amount must be greater than zero")
        Double amount
) {
}
