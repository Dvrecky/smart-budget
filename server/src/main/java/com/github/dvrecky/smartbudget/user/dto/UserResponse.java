package com.github.dvrecky.smartbudget.user.dto;

import com.github.dvrecky.smartbudget.user.domain.UserStatus;

import java.time.Instant;

public record UserResponse(
        Long id,
        String name,
        String surname,
        String email,
        UserStatus status,
        boolean mfaEnabled,
        Instant createdAt
) {
}
