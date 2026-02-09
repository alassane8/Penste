package com.example.penste.user.application.port.in;

import com.example.penste.user.adapter.in.web.dto.UpdateUserCommand;
import com.example.penste.user.domain.model.User;

public interface UpdateUserUseCase {

    /**Update User
     * @return updated user
     * @param command Create user command
     */
    User updateUser(UpdateUserCommand command);
}
