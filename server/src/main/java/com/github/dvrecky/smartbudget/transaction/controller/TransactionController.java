package com.github.dvrecky.smartbudget.transaction.controller;

import com.github.dvrecky.smartbudget.common.utils.PaginationUtils;
import com.github.dvrecky.smartbudget.constants.ApiPaths;
import com.github.dvrecky.smartbudget.security.service.CustomUserDetails;
import com.example.budget_management_app.transaction.dto.*;
import com.github.dvrecky.smartbudget.transaction.dto.*;
import com.github.dvrecky.smartbudget.transaction.service.TransactionService;
import com.github.dvrecky.smartbudget.transaction_common.dto.PagedResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/transactions", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<PagedResponse<TransactionSummary>> getSummariesPage(
            @Valid TransactionPaginationParams paginationParams,
            @Valid TransactionFilterParams filterParams,
            @AuthenticationPrincipal CustomUserDetails userDetails
            ) {

        PagedResponse<TransactionSummary> summariesPage = transactionService.getSummariesPage(
                paginationParams,
                filterParams,
                userDetails.getId()
        );

        return ResponseEntity.ok(summariesPage.withLinks(PaginationUtils.createLinks(summariesPage.pagination())));
    }

    @PostMapping
    public ResponseEntity<TransactionCreateResponse> create(
            @RequestBody @Valid TransactionCreateRequest transactionCreate,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        TransactionCreateResponse response = transactionService.create(transactionCreate, userDetails.getId());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(ApiPaths.BASE_API)
                        .pathSegment(ApiPaths.VERSIONING)
                        .pathSegment(ApiPaths.TRANSACTIONS)
                        .pathSegment(String.valueOf(response.id()))
                        .build().toUri()
                )
                .body(response);
    }

    @PatchMapping("/{id}/category")
    public ResponseEntity<TransactionCategoryChangeResponse> changeCategory(
            @PathVariable @Positive(message = "The transaction id value must be positive") Long id,
            @RequestBody @Valid TransactionCategoryChangeRequest updateReq,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        return ResponseEntity.ok(transactionService.changeCategory(
                id,
                updateReq,
                userDetails.getId()
        ));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable @Positive(message = "The transaction id value must be positive") Long id,
            @RequestBody @Valid TransactionUpdateRequest updateReq,
            @AuthenticationPrincipal CustomUserDetails userDetails
            ) {

        transactionService.update(id, updateReq, userDetails.getId());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable @Positive(message = "The transaction id value must be positive") Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        transactionService.delete(id, userDetails.getId());

        return ResponseEntity.noContent().build();
    }
}
