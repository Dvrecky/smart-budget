package com.github.dvrecky.smartbudget.session.dto;

import com.github.dvrecky.smartbudget.auth.dto.LoginResponse;

public record RefreshTokenResult(
        LoginResponse loginResponse,
        String cookie
) {
}
