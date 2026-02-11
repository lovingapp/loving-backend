package com.lovingapp.mapper;

import org.springframework.stereotype.Component;

import com.lovingapp.model.dto.ChatDTOs.ChatSessionDTO;
import com.lovingapp.model.entity.ChatSession;

@Component
public final class ChatSessionMapper {

    public static ChatSessionDTO toDto(ChatSession session) {
        if (session == null) {
            return null;
        }

        return ChatSessionDTO.builder()
                .id(session.getId())
                .title(session.getTitle())
                .lastMessagePreview(session.getLastMessagePreview())
                .createdAt(session.getCreatedAt())
                .updatedAt(session.getUpdatedAt())
                .build();
    }
}
