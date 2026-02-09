package com.example.penste.user.adapter.in.web;

import com.example.penste.infrastructure.web.config.EndpointsConfig;
import com.example.penste.user.adapter.in.web.dto.UpdateUserCommand;
import com.example.penste.user.adapter.in.web.dto.UserRequestBody;
import com.example.penste.user.adapter.in.web.dto.assemble.UserResponse;
import com.example.penste.user.application.port.in.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.example.penste.infrastructure.web.config.EndpointsConfig.SERVER_API_V1;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(SERVER_API_V1)
public class UpdateUserController {

    private final UpdateUserUseCase updateUserUseCase;

    @PutMapping(EndpointsConfig.USERS + "/{uuid}")
    public ResponseEntity<UserResponse> updateUser(
            @RequestBody UserRequestBody requestBody,
            @PathVariable String uuid)
    {
        log.info("Initializing user {} update.",
                requestBody.getFirstName() + requestBody.getLastName()
        );

        var command = UpdateUserCommand.createCommandFrom(requestBody);
        var updatedUser = updateUserUseCase.updateUser(command);

        var response = UserResponse.mapToResponse(updatedUser);

        return ResponseEntity
                .created(URI.create("/api/users/" + updatedUser.getUuid()))
                .body(response);
    }
}
