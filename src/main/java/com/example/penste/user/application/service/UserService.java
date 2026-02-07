package com.example.penste.user.application.service;

import com.example.penste.user.adapter.in.web.dto.CreateUserCommand;
import com.example.penste.user.adapter.out.persistence.UserAdapter;
import com.example.penste.user.adapter.out.persistence.UserEntity;
import com.example.penste.user.adapter.out.persistence.UserMapper;
import com.example.penste.user.application.port.in.CreateUserUseCase;
import com.example.penste.user.application.port.in.GetUserUseCase;
import com.example.penste.user.domain.exception.UserAlreadyExistsException;
import com.example.penste.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements
        GetUserUseCase,
        CreateUserUseCase {

    private final UserAdapter userAdapter;
    private final UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        log.info("Service: loading all existing users in progress");

        List<UserEntity> userEntities = userAdapter.findAllUsers();

        List<User> users = userEntities.stream()
                .map(userMapper::mapToUser)
                .toList();

        log.info("Service: {} user(s) found", users.size());

        return users;
    }

    @Override
    public User createUser(CreateUserCommand command) {
        log.info("Service: User creation with email: {}", command.getEmail());

        if (userAdapter.existsByEmail(command.getEmail())) {
            throw new UserAlreadyExistsException(
                    "User with email " + command.getEmail() + " already exists"
            );
        }

        User user = User.builder()
                .uuid(UUID.randomUUID().toString())
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .email(command.getEmail())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        UserEntity savedEntity = userAdapter.saveUser(user);

        User savedUser = userMapper.mapToUser(savedEntity);

        log.info("Service: Successful user creation, UUID: {}", savedUser.getUuid());

        return savedUser;
    }
}
