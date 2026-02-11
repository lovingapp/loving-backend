package com.lovingapp.mapper;

import org.springframework.stereotype.Component;

import com.lovingapp.model.dto.ChatDTOs.ChatMessageDTO;
import com.lovingapp.model.entity.ChatMessage;

@Component
public final class ChatMessageMapper {

    public static ChatMessageDTO toDto(ChatMessage message) {
        if (message == null) {
            return null;
        }

        return ChatMessageDTO.builder()
                .id(message.getId())
                .sessionId(message.getSessionId())
                .role(message.getRole())
                .content(message.getContent())
                .metadata(message.getMetadata())
                .createdAt(message.getCreatedAt())
                .build();
    }
}
