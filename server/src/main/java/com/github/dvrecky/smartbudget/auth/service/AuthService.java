package com.github.dvrecky.smartbudget.auth.service;

import com.example.budget_management_app.auth.dto.*;
import com.github.dvrecky.smartbudget.auth.dto.*;
import com.github.dvrecky.smartbudget.common.dto.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {

    ResponseMessage registerUser(RegistrationRequest dto);

    LoginResult authenticateUser(LoginRequest dto, HttpServletRequest request, String oldRefreshToken);

    LoginResult authenticateWith2fa(TwoFactorLoginRequest dto, HttpServletRequest request, String oldRefreshToken);

    void verifyUser(String code);

    ResponseMessage resendVerification(String email);

    void resetPasswordConfirm(PasswordResetConfirmation dto);

    ResponseMessage resetPassword(PasswordResetRequest dto);

}
