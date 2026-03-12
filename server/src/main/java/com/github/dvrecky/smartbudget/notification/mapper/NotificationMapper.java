package com.github.dvrecky.smartbudget.notification.mapper;

import com.github.dvrecky.smartbudget.notification.domain.Notification;
import com.github.dvrecky.smartbudget.notification.dto.NotificationDto;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public NotificationDto toDto(Notification notification) {
        return new NotificationDto(
                notification.getId(),
                notification.getTitle(),
                notification.getMessage(),
                notification.getType(),
                notification.isRead(),
                notification.getCreatedAt(),
                notification.getTargetUrl()
        );
    }
}
