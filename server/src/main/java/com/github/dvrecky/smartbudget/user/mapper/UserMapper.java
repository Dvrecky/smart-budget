package com.github.dvrecky.smartbudget.user.mapper;

import com.github.dvrecky.smartbudget.session.domain.UserSession;
import com.github.dvrecky.smartbudget.user.domain.User;
import com.github.dvrecky.smartbudget.user.dto.UserResponse;
import com.github.dvrecky.smartbudget.user.dto.UserSessionResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getStatus(),
                user.isMfaEnabled(),
                user.getCreatedAt()
        );
    }

    public UserSessionResponse toUserSessionResponse(UserSession session, Long currentSessionId) {
        boolean isCurrent = session.getId().equals(currentSessionId);

        return new UserSessionResponse(
                session.getId(),
                session.getIpAddress(),
                session.getDeviceInfo(),
                session.getDeviceType(),
                session.getCreatedAt(),
                session.getLastUsedAt(),
                isCurrent
        );
    }
}
