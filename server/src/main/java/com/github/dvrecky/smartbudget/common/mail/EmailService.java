package com.github.dvrecky.smartbudget.common.mail;

public interface EmailService {

    void sendVerificationEmail(String userEmail, String userName, String verificationCode, boolean resend);

    void sendResetPasswordEmail(String userEmail, String userName, String token);

    void sendFinancialReport(String userEmail, String userName, byte[] data);

}
