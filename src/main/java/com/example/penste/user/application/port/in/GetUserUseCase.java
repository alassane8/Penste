package com.example.penste.user.application.port.in;

import com.example.penste.user.domain.model.User;

import java.util.List;

public interface GetUserUseCase {

    /* Get all users
    @return list of users
     */
    List<User> getAllUsers();
}
