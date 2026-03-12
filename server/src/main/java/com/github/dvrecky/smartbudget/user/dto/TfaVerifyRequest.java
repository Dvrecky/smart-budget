package com.github.dvrecky.smartbudget.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TfaVerifyRequest(
        @NotBlank(message = "Code is required.")
        @Size(min = 6, max = 6, message = "Code must contain 6 numbers")
        String code
) {
}
