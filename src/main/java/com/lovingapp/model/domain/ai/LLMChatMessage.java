package com.lovingapp.model.domain.ai;

import com.lovingapp.model.enums.ChatMessageRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LLMChatMessage {
    private ChatMessageRole role;
    private String content;
}
