package com.example.penste.user.adapter.in.web;

import com.example.penste.user.adapter.in.web.dto.AssembleUsersResponse;
import com.example.penste.user.adapter.in.web.dto.UserResponse;
import com.example.penste.user.application.port.in.GetUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GetUsersController {

    private final GetUserUseCase getUserUseCase;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers()
    {
        var usersPage = getUserUseCase.getAllUsers();
        var dtoList = usersPage.stream().map(AssembleUsersResponse::usersResponse).toList();

        return ResponseEntity.ok(dtoList);
    }
}
