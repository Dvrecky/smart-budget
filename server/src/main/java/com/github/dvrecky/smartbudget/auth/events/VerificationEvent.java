package com.github.dvrecky.smartbudget.auth.events;

public record VerificationEvent(
        String userEmail,
        String userName,
        String verificationCode,
        boolean resend
) {
}
