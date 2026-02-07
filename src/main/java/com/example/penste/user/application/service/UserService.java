package com.example.penste.user.application.service;

import com.example.penste.user.adapter.out.persistence.UserAdapter;
import com.example.penste.user.application.port.in.GetUserUseCase;
import com.example.penste.user.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements GetUserUseCase {

    private UserAdapter userRepositoryAdapter;

    @Override
    public List<User> getAllUsers() {
        return userRepositoryAdapter.getAllUsers();
    }
}
