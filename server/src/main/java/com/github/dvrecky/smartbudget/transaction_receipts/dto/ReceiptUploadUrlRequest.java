package com.github.dvrecky.smartbudget.transaction_receipts.dto;

public record ReceiptUploadUrlRequest(
        String fileName,
        String fileType,
        Long fileSize
) {
}
