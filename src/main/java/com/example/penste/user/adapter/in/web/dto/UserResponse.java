package com.example.penste.user.adapter.in.web.dto;

import com.example.penste.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;


    public static UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
