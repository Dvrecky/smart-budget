package com.github.dvrecky.smartbudget.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ResendVerificationRequest(
        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Email should be valid")
        String email
) {
}
