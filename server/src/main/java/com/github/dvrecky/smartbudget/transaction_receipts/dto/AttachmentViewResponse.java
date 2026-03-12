package com.github.dvrecky.smartbudget.transaction_receipts.dto;

import java.time.LocalDateTime;

public record AttachmentViewResponse(
        String originalFileName,
        String downloadUrl,
        LocalDateTime expiresAt
) {
}
