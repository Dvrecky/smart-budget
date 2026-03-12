package com.github.dvrecky.smartbudget.chat.service;

import com.github.dvrecky.smartbudget.chat.dto.Chat;
import com.github.dvrecky.smartbudget.chat.dto.ChatMessage;
import com.github.dvrecky.smartbudget.chat.dto.ChatStartResponse;

import java.util.List;

public interface ChatService {

    ChatStartResponse createChat(Long userId, String message);

    List<Chat> getAllChatsForUser(Long userId);

    List<ChatMessage> getChatMessages(String id, Long userId);

    String chat(String chatId, Long userId, String message, boolean justCreated);
}
