package com.example.penste.user.adapter.in.web;

import com.example.penste.infrastructure.web.config.EndpointsConfig;
import com.example.penste.user.adapter.in.web.dto.AssembleUsersResponse;
import com.example.penste.user.adapter.in.web.dto.UserResponse;
import com.example.penste.user.application.port.in.GetUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.penste.infrastructure.web.config.EndpointsConfig.SERVER_API_V1;

@RestController
@RequiredArgsConstructor
@RequestMapping(SERVER_API_V1)
public class GetUsersController {

    private final GetUserUseCase getUserUseCase;

    @GetMapping(EndpointsConfig.USERS)
    public ResponseEntity<List<UserResponse>> getUsers()
    {
        var users = getUserUseCase.getAllUsers()
                .stream()
                .map(AssembleUsersResponse::usersResponse)
                .toList();

        return ResponseEntity.ok(users);
    }
}
