package com.github.dvrecky.smartbudget.auth.events;

public record PasswordResetEvent(
        String userEmail,
        String userName,
        String token
) {
}
