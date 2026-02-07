package com.example.penste.user.adapter.out.persistence;

import com.example.penste.user.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUserEntity(UserEntity user) {
        return User.builder()
                .uuid(user.getUuid())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
