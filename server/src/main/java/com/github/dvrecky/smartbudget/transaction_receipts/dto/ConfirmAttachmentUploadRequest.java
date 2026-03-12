package com.github.dvrecky.smartbudget.transaction_receipts.dto;

public record ConfirmAttachmentUploadRequest(
        String originalFileName,
        String key
) {
}
