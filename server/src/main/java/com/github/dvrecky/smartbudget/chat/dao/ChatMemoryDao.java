package com.github.dvrecky.smartbudget.chat.dao;

import com.github.dvrecky.smartbudget.chat.dto.Chat;
import com.github.dvrecky.smartbudget.chat.dto.ChatMessage;

import java.util.List;

public interface ChatMemoryDao {

    String createChat(Long userId, String description);

    boolean chatExists(String id, Long userId);

    List<Chat> getAllChatsForUser(Long userId);

    List<ChatMessage> getChatMessages(String id);

    int updateLastUsage(String id);
}
