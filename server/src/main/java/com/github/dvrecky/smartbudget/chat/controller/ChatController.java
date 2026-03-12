package com.github.dvrecky.smartbudget.chat.controller;

import com.github.dvrecky.smartbudget.chat.constants.Constants;
import com.github.dvrecky.smartbudget.chat.dto.Chat;
import com.github.dvrecky.smartbudget.chat.dto.ChatMessage;
import com.github.dvrecky.smartbudget.chat.dto.ChatRequest;
import com.github.dvrecky.smartbudget.chat.dto.ChatStartResponse;
import com.github.dvrecky.smartbudget.chat.service.ChatService;
import com.github.dvrecky.smartbudget.constants.ApiPaths;
import com.github.dvrecky.smartbudget.security.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/chats", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<List<Chat>> getAllChatsForUser(
            @AuthenticationPrincipal CustomUserDetails userDetails
            ) {
        return ResponseEntity.ok(chatService.getAllChatsForUser(userDetails.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ChatMessage>> getChatMessages(
            @PathVariable String id,
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(chatService.getChatMessages(id, userDetails.getId()));
    }

    @PostMapping
    public ResponseEntity<ChatStartResponse> startNewChat(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody ChatRequest request
            ) {

        ChatStartResponse response = chatService.createChat(userDetails.getId(), request.message());

        return ResponseEntity
                .created(UriComponentsBuilder.fromPath(ApiPaths.BASE_API)
                        .pathSegment(ApiPaths.VERSIONING)
                        .pathSegment(ApiPaths.CHATS)
                        .pathSegment(String.valueOf(response.chatId()))
                        .build().toUri())
                .body(response);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ChatMessage> sendMessage(
            @PathVariable String id,
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody ChatRequest request) {
        return ResponseEntity.ok(new ChatMessage(chatService.chat(id, userDetails.getId(), request.message(), false), Constants.ASSISTANT_MESSAGE_TYPE));
    }
}
