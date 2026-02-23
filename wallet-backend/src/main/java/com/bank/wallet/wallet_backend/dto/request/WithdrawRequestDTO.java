package com.bank.wallet.wallet_backend.dto.request;

import java.util.UUID;

public record WithdrawRequestDTO(
        UUID userId,
        Double amount
) {
}
