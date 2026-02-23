package com.bank.wallet.wallet_backend.dto.request;

import com.bank.wallet.wallet_backend.enums.Role;
import jakarta.validation.constraints.*;

public record UserRegistrationRequestDTO(

        @NotBlank(message = "First name is required")
        @Size(max = 40, message = "First name is too long")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(max = 40, message = "Last name is too long")
        String lastName,

        @NotBlank(message = "Username is required")
        @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
        String username,

        @NotBlank(message = "Email is required")
        @Email(message = "Please provide a valid email address")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password,

        @NotNull(message = "Age is required")
        @Min(value = 18, message = "You must be at least 18 years old to open a wallet")
        @Max(value = 120, message = "Please enter a valid age")
        int age,
        Role role
) {
}
