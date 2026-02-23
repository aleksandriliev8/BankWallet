package com.bank.wallet.wallet_backend.dto.request;

import java.util.UUID;

public record DepositRequestDTO(
        UUID userId,
        Double amount
) {
}
