package com.lovingapp.mapper;

import org.springframework.stereotype.Component;

import com.lovingapp.model.dto.UserDTOs.UserDTO;
import com.lovingapp.model.dto.UserDTOs.UserUpdateRequest;
import com.lovingapp.model.entity.User;

@Component
public final class UserMapper {

    public static UserDTO toDto(User entity) {
        if (entity == null) {
            return null;
        }

        return UserDTO.builder()
                .id(entity.getId())
                .authUserId(entity.getAuthUserId())
                .email(entity.getEmail())
                .displayName(entity.getDisplayName())
                .onboardingCompleted(entity.getOnboardingCompleted())
                .lastLoginAt(entity.getLastLoginAt())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static void updateEntity(UserUpdateRequest request, User entity) {
        if (request == null || entity == null) {
            return;
        }

        if (request.getOnboardingCompleted() != null) {
            entity.setOnboardingCompleted(request.getOnboardingCompleted());
        }

        if (request.getDisplayName() != null) {
            entity.setDisplayName(request.getDisplayName());
        }
    }
}
