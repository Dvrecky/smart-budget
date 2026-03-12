package com.github.dvrecky.smartbudget.auth.dto;

import org.springframework.http.ResponseCookie;

public record LoginResult(
        LoginResponse response,
        ResponseCookie cookie
) {
    public static LoginResult mfaRequired(LoginResponse response) {
        return new LoginResult(response, null);
    }
}