package com.github.dvrecky.smartbudget.notification.dto;

import com.github.dvrecky.smartbudget.notification.domain.NotificationType;

import java.time.Instant;

public record NotificationDto(
        Long id,
        String title,
        String message,
        NotificationType type,
        boolean isRead,
        Instant createdAt,
        String targetUrl
) {
}
