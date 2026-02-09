package com.example.penste.user.application.port.out;

import com.example.penste.user.adapter.out.persistence.UserEntity;

public interface UpdateUserPort {

    /** Update user return the updated user
     *  @return saved user
     *  @param userToUpdate user to be updated
     */
    UserEntity updateUser(UserEntity userToUpdate);
}
