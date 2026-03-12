package com.github.dvrecky.smartbudget.auth.mapper;

import com.github.dvrecky.smartbudget.auth.dto.LoginResponse;
import com.github.dvrecky.smartbudget.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public LoginResponse toLoginResponse(User user, String accessToken, boolean isMfaRequired) {
        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getStatus(),
                user.isMfaEnabled(),
                user.getCreatedAt(),
                accessToken,
                isMfaRequired
        );
    }

}
