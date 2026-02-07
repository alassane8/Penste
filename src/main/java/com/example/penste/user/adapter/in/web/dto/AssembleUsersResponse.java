package com.example.penste.user.adapter.in.web.dto;

import com.example.penste.user.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class AssembleUsersResponse {

    public static UserResponse usersResponse(User user){
        return new UserResponse(
                user.getUuid(),
                user.getFirstName(),
                user.getEmail()
        );
    }
}
