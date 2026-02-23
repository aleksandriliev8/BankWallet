package com.bank.wallet.wallet_backend.dto.response;

import java.util.UUID;

public record WalletResponseDTO(
        UUID id,
        Double balance
) {
}