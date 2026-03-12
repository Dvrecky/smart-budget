package com.github.dvrecky.smartbudget.chat.dto;

public record ChatStartResponse(
        String chatId,
        String message,
        String description
) {
}
