package com.bank.wallet.wallet_backend.dto.error;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        String message,
        int status,
        String path
) {}
