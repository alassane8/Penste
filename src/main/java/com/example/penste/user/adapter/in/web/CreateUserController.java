package com.example.penste.user.adapter.in.web;

import com.example.penste.infrastructure.web.config.EndpointsConfig;
import com.example.penste.user.adapter.in.web.dto.CreateUserCommand;
import com.example.penste.user.adapter.in.web.dto.CreateUserRequestBody;
import com.example.penste.user.adapter.in.web.dto.assemble.UserResponse;
import com.example.penste.user.application.port.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.example.penste.infrastructure.web.config.EndpointsConfig.SERVER_API_V1;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(SERVER_API_V1)
public class CreateUserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping(EndpointsConfig.USERS)
    public ResponseEntity<UserResponse> createUser(
            @RequestBody CreateUserRequestBody requestBody
    ) {

        log.info("Initializing user {} creation with {} email.",
                requestBody.getFirstName() + requestBody.getLastName(),
                requestBody.getEmail()
        );

        var command = CreateUserCommand.createCommandFrom(requestBody);
        var createdUser = createUserUseCase.createUser(command);

        var response = UserResponse.mapToResponse(createdUser);

        return ResponseEntity
                .created(URI.create("/api/users/" + createdUser.getFirstName()))
                .body(response);

    }
}
