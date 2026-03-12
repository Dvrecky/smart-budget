package com.github.dvrecky.smartbudget.user.dto;

import com.github.dvrecky.smartbudget.session.domain.DeviceType;

import java.time.Instant;

public record UserSessionResponse(
        Long id,
        String ipAddress,
        String deviceInfo,
        DeviceType deviceType,
        Instant createdAt,
        Instant lastUsedAt,
        Boolean isCurrent
) {
}
