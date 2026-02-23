package com.bank.wallet.wallet_backend.dto.user.response;

import com.bank.wallet.wallet_backend.dto.wallet.response.WalletResponseDTO;

import java.util.UUID;

// For security reasons we do not want our response to the FE to contain the user password.
// We are preventing data vulnerabilities and unwanted data access by third parties
public record UserResponseDTO(
        UUID id,
        String username,
        String email,
        WalletResponseDTO wallet
) {
}
