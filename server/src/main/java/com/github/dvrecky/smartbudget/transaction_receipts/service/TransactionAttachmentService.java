package com.github.dvrecky.smartbudget.transaction_receipts.service;

import com.github.dvrecky.smartbudget.transaction_receipts.dto.ConfirmAttachmentUploadRequest;
import com.github.dvrecky.smartbudget.transaction_receipts.dto.AttachmentViewResponse;
import com.github.dvrecky.smartbudget.transaction_receipts.dto.ReceiptUploadUrlRequest;
import com.github.dvrecky.smartbudget.transaction_receipts.dto.ReceiptUploadUrlResponse;

public interface TransactionAttachmentService {

    ReceiptUploadUrlResponse getPresignedPutUrl(Long transactionId, ReceiptUploadUrlRequest uploadReq, Long userId);

    AttachmentViewResponse confirmAttachmentUpload(Long transactionId, ConfirmAttachmentUploadRequest attachFileReq, Long userId);

    AttachmentViewResponse getPresignedGetUrl(Long transactionId, Long userId);
}
