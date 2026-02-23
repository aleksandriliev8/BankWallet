package com.bank.wallet.wallet_backend.dto.request;

import java.util.UUID;

public record TransferRequest(
        UUID fromUserId,
        UUID toUserId,
        Double amount
) {
}
