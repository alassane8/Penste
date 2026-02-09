package com.example.penste.user.application.port.in;

import com.example.penste.user.adapter.in.web.dto.CreateUserCommand;
import com.example.penste.user.domain.model.User;

public interface CreateUserUseCase {

    /**Create User
     * @return created user
     * @param command Create user command
     */
    User createUser(CreateUserCommand command);

}
