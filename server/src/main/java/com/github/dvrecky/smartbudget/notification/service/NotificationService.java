package com.github.dvrecky.smartbudget.notification.service;

import com.github.dvrecky.smartbudget.notification.domain.NotificationType;
import com.github.dvrecky.smartbudget.notification.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    void createAndSend(Long userId, String title, String message, NotificationType type, String targetUrl);

    List<NotificationDto> getUserNotifications(Long userId, boolean isRead);

    long countUnread(Long userId);

    void markAsRead(Long notificationId, Long userId);

    void markAllAsRead(Long userId);
}
