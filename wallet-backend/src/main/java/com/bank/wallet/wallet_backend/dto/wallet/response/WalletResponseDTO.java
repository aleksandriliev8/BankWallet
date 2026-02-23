package com.bank.wallet.wallet_backend.dto.wallet.response;

import java.util.UUID;

public record WalletResponseDTO(
        UUID id,
        Double balance
) {
}