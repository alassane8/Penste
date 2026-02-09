package com.example.penste.user.adapter.in.web.dto.assemble;

import com.example.penste.user.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class AssembleUsersResponse {

    public static UserResponse usersResponse(User user){
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
