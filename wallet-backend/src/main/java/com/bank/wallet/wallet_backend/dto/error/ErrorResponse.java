package com.bank.wallet.wallet_backend.dto.error;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        LocalDateTime timestamp,
        String message,
        int status,
        String path,
        Map<String, String> errors
) {
    public ErrorResponse(LocalDateTime timestamp, String message, int status, String path) {
        this(timestamp, message, status, path, null);
    }
}
